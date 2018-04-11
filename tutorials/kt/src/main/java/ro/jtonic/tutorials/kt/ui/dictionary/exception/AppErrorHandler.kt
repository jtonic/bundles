package ro.jtonic.tutorials.kt.ui.dictionary.exception

import javafx.application.Platform
import javafx.scene.control.Alert
import javafx.scene.control.Label
import javafx.scene.control.TextArea
import javafx.scene.layout.VBox
import javafx.scene.paint.Color
import tornadofx.*
import java.io.ByteArrayOutputStream
import java.io.PrintWriter
import java.util.logging.Level
import java.util.logging.Logger

/**
 * Created by Antonel Ernest Pazargic on 11/04/2018.
 * @author Antonel Ernest Pazargic
 */
class AppErrorHandler  : Thread.UncaughtExceptionHandler {

    private val log = Logger.getLogger("ErrorHandler")!!

    class ErrorEvent(val thread: Thread, val error: Throwable) {
        internal var consumed = false
        fun consume() {
            consumed = true
        }
    }

    companion object {
        // By default, all error messages are shown. Override to decide if certain errors should be handled another way.
        // Call consume to avoid error dialog.
        var filter: (ErrorEvent) -> Unit = { }
    }

    override fun uncaughtException(t: Thread, error: Throwable) {
        log.log(Level.SEVERE, "Uncaught error", error)

        if (isCycle(error)) {
            log.log(Level.INFO, "Detected cycle handling error, aborting.", error)
        } else {
            val event = ErrorEvent(t, error)
            filter(event)

            if (!event.consumed) {
                event.consume()
                Platform.runLater {
                    showErrorDialog(error)
                }
            }
        }

    }

    private fun isCycle(error: Throwable) = error.stackTrace.any {
        it.className.startsWith("${javaClass.name}\$uncaughtException$")
    }

    private fun showErrorDialog(error: Throwable) {
        val cause = Label(if (error.cause != null) error.cause?.message else "").apply {
            style = "-fx-font-weight: bold"
        }

        val textarea = TextArea().apply {
            prefRowCount = 20
            prefColumnCount = 50
            text = stringFromError(error)
        }

        Alert(Alert.AlertType.ERROR).apply {
            title = error.message ?: "An error occurred"
            isResizable = true
            headerText = if (error.stackTrace?.isEmpty() != false) "Error" else "Error in " + error.stackTrace[0].toString()
            dialogPane.content = VBox().apply {
                add(cause)
                if (error is RestException) {
                    try {

                        title = "HTTP Request Error: $title"
                        form {
                            fieldset(error.message) {
                                val response = error.response
                                if (response != null) {
                                    field("Status") {
                                        label("${response.statusCode} ${response.reason}")
                                    }

                                    val c = response.text()

                                    if (c != null) {
                                        tabpane {
                                            background = Color.TRANSPARENT.asBackground()

                                            tab("Plain text") {
                                                textarea(c)
                                            }
                                            tab("HTML") {
                                                if (response.header("Content-Type")?.contains("html", true) == true)
                                                    select()

                                                webview {
                                                    engine.loadContent(c)
                                                }
                                            }
                                            tab("Stacktrace") {
                                                add(textarea)
                                            }
                                            tabs.withEach { isClosable = false }
                                        }
                                    } else {
                                        add(textarea)
                                    }
                                } else {
                                    add(textarea)
                                }
                            }
                        }

                    } catch (e: Exception) {
                        add(textarea)
                    }
                } else {
                    add(textarea)
                }
            }

            showAndWait()
        }
    }

}

private fun stringFromError(e: Throwable): String {
    val out = ByteArrayOutputStream()
    val writer = PrintWriter(out)
    e.printStackTrace(writer)
    writer.close()
    return out.toString()
}
