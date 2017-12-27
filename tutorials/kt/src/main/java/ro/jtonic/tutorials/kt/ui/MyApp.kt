package ro.jtonic.tutorials.kt.ui

import javafx.application.Application
import javafx.collections.FXCollections
import javafx.geometry.Pos
import javafx.scene.layout.VBox
import javafx.scene.paint.Color
import tornadofx.*

/**
 * Created by Antonel Ernest Pazargic on 24/12/2017.
 * @author Antonel Ernest Pazargic
 */
class MyApp : App(MyView::class)

class MyView : View() {

    override val root: VBox = vbox {
        hbox {
            label("First name")
            textfield()
        }
        hbox {
            label("Last name")
            textfield()
        }
        hbox {
            label("Environment")
            combobox<String> {
                items = FXCollections.observableArrayList("LOCAL", "DEV", "TST", "ACC")
            }
        }
        checkbox("Admin") {
            action { println(if (isSelected) "admin" else "user") }
        }
        button("Login").apply {
            textFill = Color.RED
            alignment = Pos.CENTER
            action {
                println("Logged in!!!")
            }
        }
    }
}

fun main(args: Array<String>) {
    Application.launch(MyApp::class.java, *args)
}
