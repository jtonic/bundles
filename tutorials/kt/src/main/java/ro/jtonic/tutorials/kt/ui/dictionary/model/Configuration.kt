package ro.jtonic.tutorials.kt.ui.dictionary.model

import javafx.beans.property.SimpleStringProperty
import tornadofx.*

/**
 * Created by Antonel Ernest Pazargic on 02/04/2018.
 * @author Antonel Ernest Pazargic
 */
class Configuration(corporateKey: String) {

    val corporateKeyProp = SimpleStringProperty(corporateKey)
    var corporateKey: String by corporateKeyProp

    override fun toString(): String {
        return "Configuration(corporateKeyProp=${corporateKeyProp.value})"
    }

    companion object CONFIG {

        @JvmField
        var CORPORATE_KEY: String = "grantsapi.inputdata.corporatekey"
    }
}

