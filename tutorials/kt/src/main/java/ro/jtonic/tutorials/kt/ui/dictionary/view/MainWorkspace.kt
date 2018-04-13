package ro.jtonic.tutorials.kt.ui.dictionary.view

import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIcon.BOOK_OPEN
import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIcon.DELETE_CIRCLE
import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIconView
import javafx.beans.property.SimpleStringProperty
import javafx.scene.control.Tooltip
import javafx.stage.Modality
import tornadofx.*

/**
 * Created by Antonel Ernest Pazargic on 01/04/2018.
 * @author Antonel Ernest Pazargic
 */
class MainWorkspace : Workspace(navigationMode = NavigationMode.Tabs) {

    private val wordsView: WordsView by inject()

    private val configurationView: ConfigurationView by lazy {
        find<ConfigurationView>()
    }

    private val selectedEnv = SimpleStringProperty()

    private val environments = listOf("Dev", "Test", "Acc", "Prod").observable()

    init {
        add<MainMenu>()
        dock(wordsView)
//        dock(documentationView)
        backButton.arm()
        headingContainer.removeFromParent()

        with(rightDrawer) {
            item("Links") {
                webview {
                    prefWidth = 600.0
                    engine.load("http://www.google.com")
                }
            }
        }
    }

    override fun onDock() {
        button("Configuration...") {
            addClass("icon-only")
            graphic = MaterialDesignIconView(DELETE_CIRCLE).apply {
                glyphSize = 22
            }
            action {
                configurationView.openModal(modality = Modality. NONE)
            }
        }
        button("Documentation") {
            addClass("icon-only")
            graphic = MaterialDesignIconView(BOOK_OPEN).apply {
                glyphSize = 22
            }
            action {
                log.info("Documentation...")
                find<DocumentationView>().openWindow(modality = Modality.APPLICATION_MODAL)
            }
        }
        combobox(property = selectedEnv, values = environments) {
            addClass("icon-only")
            tooltip = Tooltip("Select the environment")
            selectedEnv.value = "Acc"
        }
    }
}
