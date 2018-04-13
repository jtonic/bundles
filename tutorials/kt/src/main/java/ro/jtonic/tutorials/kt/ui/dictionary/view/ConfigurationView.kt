package ro.jtonic.tutorials.kt.ui.dictionary.view

import javafx.geometry.Orientation
import javafx.scene.control.TextField
import ro.jtonic.tutorials.kt.ui.dictionary.app.configModel
import ro.jtonic.tutorials.kt.ui.dictionary.css.Style
import ro.jtonic.tutorials.kt.ui.dictionary.model.Configuration
import tornadofx.*

/**
 * Created by Antonel Ernest Pazargic on 13/04/2018.
 * @author Antonel Ernest Pazargic
 */
class ConfigurationView : Fragment("Configuration") {

    private val configModel = app.configModel

    private var corporateKeyTxtFld: TextField by singleAssign()

    override val root = borderpane {
        center {
            form {
                fieldset {
                    field(text = "Corporate Key", orientation = Orientation.HORIZONTAL) {
                        textfield(property = configModel.corporateKey) {
                            corporateKeyTxtFld = this
                            validator(trigger = ValidationTrigger.OnChange(delay = 700)) {
                                if (it.isNullOrBlank()) error("A non-empty corporateKey is required") else null
                            }
                        }
                    }
                }
                buttonbar {
                    button("Apply") {
                        addClass(Style.buttonFaceColor)
                        enableWhen(configModel.valid.and(configModel.dirty))
                        action {
                            if (configModel.isDirty) {
                                configModel.commit()
                                app.config.set(Configuration.CONFIG.CORPORATE_KEY to configModel.configuration.corporateKey)
                                app.config.save()
                                close()
                            }
                        }
                    }
                    button("Reset") {
                        addClass(Style.buttonFaceColor)
                        enableWhen(configModel.dirty)
                        action {
                            configModel.rollback()
                        }
                    }
                }
            }
        }
    }

    init {
        root.run {
            prefHeight = 300.0
            prefWidth = 500.0
            maxHeight = 900.0
            maxWidth = 1_200.0
        }
    }

    override fun onDock() {
        configModel.validate(decorateErrors = false)
    }

    override fun onUndock() {
        if(configModel.isDirty) {
            configModel.rollback()
        }
    }
}
