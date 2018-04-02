package ro.jtonic.tutorials.kt.ui.dictionary.model

import javafx.beans.property.SimpleStringProperty
import tornadofx.*

/**
 * Created by Antonel Ernest Pazargic on 02/04/2018.
 * @author Antonel Ernest Pazargic
 */
class About() {
    val valueProperty = SimpleStringProperty()
    var value by valueProperty
    val keyProperty = SimpleStringProperty()
    var key by keyProperty
}

