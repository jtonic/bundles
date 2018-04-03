package ro.jtonic.tutorials.kt.ui.dictionary.view

import tornadofx.*

/**
 * Created by Antonel Ernest Pazargic on 01/04/2018.
 * @author Antonel Ernest Pazargic
 */
class MainMenu : UIComponent() {

    override val root = menubar {
        menu("Help") {
            item("About", "Shortcut+A").action {
                find<AboutView>().apply {
                    openModal()
                }
            }
        }
    }
}
