package ro.jtonic.tutorials.kt.ui.dictionary.view

import javafx.beans.property.SimpleIntegerProperty
import javafx.scene.control.Label
import javafx.scene.layout.BorderPane
import tornadofx.*

/**
 * Created by Antonel Ernest Pazargic on 16/02/2018.
 * @author Antonel Ernest Pazargic
 */
class MainView : View("My View") {

//    override val root: BorderPane by fxml("/views/MainView.fxml")
    override val root: BorderPane by fxml()

    val counter = SimpleIntegerProperty()
    val counterLabel: Label by fxid()

    init {
        counterLabel.bind(counter)
    }

    fun increment() {
        counter.value += 1
    }
}
