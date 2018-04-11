package ro.jtonic.tutorials.kt.ui.dictionary.model

import javafx.beans.property.SimpleStringProperty
import tornadofx.*

/**
 * Created by Antonel Ernest Pazargic on 02/04/2018.
 * @author Antonel Ernest Pazargic
 */
class About(key: String, value: String) {

    val keyProperty = SimpleStringProperty(key)
    var key by keyProperty
    val valueProperty = SimpleStringProperty(value)
    var value by valueProperty

    override fun toString(): String {
        return "About(keyProperty=${keyProperty.value}, valueProperty=${valueProperty.value})"
    }
}

