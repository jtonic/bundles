package ro.jtonic.tutorials.kt.ui.dictionary.model

import javafx.beans.property.SimpleStringProperty
import tornadofx.*

/**
 * Created by Antonel Ernest Pazargic on 02/04/2018.
 * @author Antonel Ernest Pazargic
 */
class Configuration(cKey: String) {

    val cKeyProp = SimpleStringProperty(cKey)
    var cKey: String by cKeyProp

    override fun toString(): String {
        return "Configuration(cKeyProp=${cKeyProp.value})"
    }

    companion object CONFIG {

        @JvmField
        var C_KEY: String = "grantsapi.inputdata.ckey"
    }
}

