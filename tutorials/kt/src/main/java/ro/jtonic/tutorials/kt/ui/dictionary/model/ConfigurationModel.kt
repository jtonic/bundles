package ro.jtonic.tutorials.kt.ui.dictionary.model

import tornadofx.*

/**
 * Created by Antonel Ernest Pazargic on 13/04/2018.
 * @author Antonel Ernest Pazargic
 */
class ConfigurationModel(var configuration: Configuration) : ViewModel() {

    val corporateKey = bind { configuration.corporateKeyProp }
}
