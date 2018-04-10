package ro.jtonic.tutorials.kt.ui.dictionary.view

import tornadofx.*
import java.io.File
import java.util.*

/**
 * Created by Antonel Ernest Pazargic on 02/04/2018.
 * @author Antonel Ernest Pazargic
 */
class DocumentationView : Fragment("Documentation") {

    private val rand = Random()

    override val root =
            borderpane {
                center {
                    scrollpane(fitToHeight = true, fitToWidth = true) {
                        webview {
                            engine.isJavaScriptEnabled = true
                            val page = if (rand.nextInt(2) == 0)
                                "https://www.google.com"
                            else {
                                val currentDir = System.getProperty("user.dir")
                                "$currentDir/src/main/resources/index.html".toUrl
                            }
                            engine.load(page)
                        }
                    }
                }
            }

    init {
        root.prefHeight = 600.0
        root.prefWidth = 1_000.0
    }
}

private val String.toUrl: String?
    get() {
        return File(this).toURI().toURL().toExternalForm()
    }
