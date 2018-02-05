package ro.jtonic.tutorials.kt.ui.dictionary.view

import javafx.collections.FXCollections
import javafx.geometry.Pos
import javafx.scene.layout.VBox
import javafx.scene.paint.Color
import tornadofx.*

class MyView1 : View() {

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