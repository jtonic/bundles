package ro.jtonic.tutorials.kt.ui.dictionary.view

import ro.jtonic.tutorials.kt.ui.dictionary.model.About
import tornadofx.*

/**
 * Created by Antonel Ernest Pazargic on 02/04/2018.
 * @author Antonel Ernest Pazargic
 */
class AboutView : Fragment("About") {

    override val root = scrollpane(fitToWidth = true, fitToHeight = true){
        borderpane {
            val abouts = listOf(About("1", "one"), About("2", "two")).observable()

            center {
                tableview(abouts) {
                    isEditable = true
                    column("key", About::key)
                    column("value", About::key)
                }
            }
        }
    }
}
