package ro.jtonic.tutorials.kt.ui.dictionary.view

import javafx.application.Platform
import org.controlsfx.control.Notifications
import tornadofx.*

/**
 * Created by Antonel Ernest Pazargic on 01/04/2018.
 * @author Antonel Ernest Pazargic
 */
class MainMenu : UIComponent() {

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
