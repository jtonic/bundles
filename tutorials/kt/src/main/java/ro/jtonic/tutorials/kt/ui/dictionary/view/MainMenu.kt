package ro.jtonic.tutorials.kt.ui.dictionary.view

import javafx.application.Platform
import org.controlsfx.control.Notifications
import ro.jtonic.tutorials.kt.ui.dictionary.controller.HelloController
import tornadofx.*

/**
 * Created by Antonel Ernest Pazargic on 01/04/2018.
 * @author Antonel Ernest Pazargic
 */
class MainMenu : UIComponent() {

    private val helloController: HelloController by inject()

    override val root = menubar {
        menu("File") {
            item("Exit", "Shortcut+X").action {
                Platform.exit()
            }
        }
        menu("Examples") {
            item("Notification").action {
                Notifications.create().apply {
                    title("Information")
                    text("The AT has successfully generated.\nClick to get to the result.")
                    onAction {
                        println("This is the result...")
                    }
                }.also {
                    it.showInformation()
                }
            }
            item("Koin").action {
                helloController.hello()
            }

        }
        menu("Help") {
            item("About", "Shortcut+A").action {
                find<AboutView>().apply {
                    openModal()
                }
            }
        }
    }
}
