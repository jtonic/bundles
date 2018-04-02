package ro.jtonic.tutorials.kt.ui.dictionary.view

import tornadofx.*

/**
 * Created by Antonel Ernest Pazargic on 02/04/2018.
 * @author Antonel Ernest Pazargic
 */
class DocumentationView : View("Documentation") {
    override val root = borderpane {
        center {
            label {
                text = "Documentation"
            }
        }
    }
}
