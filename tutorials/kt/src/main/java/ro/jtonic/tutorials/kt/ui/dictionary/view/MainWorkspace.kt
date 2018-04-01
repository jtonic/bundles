package ro.jtonic.tutorials.kt.ui.dictionary.view

import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIcon.DELETE_CIRCLE
import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIconView
import javafx.beans.property.SimpleStringProperty
import javafx.scene.control.Tooltip
import tornadofx.*

/**
 * Created by Antonel Ernest Pazargic on 01/04/2018.
 * @author Antonel Ernest Pazargic
 */
class MainWorkspace : Workspace() {

    private val wordsView: WordsView by inject()

    private val selectedEnv = SimpleStringProperty()

    private val environments = listOf("Dev", "Test", "Acc", "Prod").observable()

    init {
        add<MainMenu>()
        dock(wordsView)
        headingContainer.hide()
    }

    override fun onDock() {
        button("Clear") {
            addClass("icon-only")
            graphic = MaterialDesignIconView(DELETE_CIRCLE).apply {
                glyphSize = 22
            }
            action {
                log.info("Add customer...")
            }
        }
        combobox(property = selectedEnv, values = environments) {
            addClass("icon-only")
            tooltip = Tooltip("Select the environment")
            selectedEnv.value = "Acc"
        }
    }
}
