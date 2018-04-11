package ro.jtonic.tutorials.kt.ui.dictionary.view

import javafx.css.PseudoClass
import javafx.scene.control.TableRow
import ro.jtonic.tutorials.kt.ui.dictionary.model.About
import tornadofx.*

/**
 * Created by Antonel Ernest Pazargic on 02/04/2018.
 * @author Antonel Ernest Pazargic
 */
class AboutView : Fragment("About") {

    private val interestedInClass = PseudoClass.getPseudoClass("interested-in")!!

    override val root = scrollpane(fitToWidth = true, fitToHeight = true) {
        borderpane {
            val abouts = listOf(About("1", "one"), About("2", "two"), About("3", "three")).observable()

            center {
                tableview(abouts) {
                    isEditable = true
                    column("key", About::key)
                    column("value", About::key)

                    setRowFactory {
                        val row = TableRow<About>()

                        row.selectedProperty().addListener { obs, wasSelected, isNowSelected ->
                            if (isNowSelected) {
                                row.removePseudoClass(interestedInClass.pseudoClassName)
                            } else if (wasSelected) {
                                if (row.item?.key?.equals("2") == true) {
                                    row.pseudoClassStateChanged(interestedInClass, true)
                                }
                            }
                        }

                        row.itemProperty().addListener { _, _, isNowSelected ->
                            log.info("row = ${isNowSelected?.toString() ?: ""}")
                            if (isNowSelected?.key?.equals("2") == true) {
                                row.pseudoClassStateChanged(interestedInClass, true)
                            }
                        }
                        row
                    }
                }
            }
        }
    }
}
