package ro.jtonic.tutorials.kt.ui

import javafx.application.Application
import javafx.collections.FXCollections
import javafx.geometry.Pos
import javafx.scene.control.DatePicker
import javafx.scene.control.TextField
import javafx.scene.layout.VBox
import javafx.scene.paint.Color
import tornadofx.*

/**
 * Created by Antonel Ernest Pazargic on 24/12/2017.
 * @author Antonel Ernest Pazargic
 */
class MyApp : App(MyView2::class)

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

class MyView2 : View() {

    override val root = form {
        lateinit var firstNameTxt: TextField
        lateinit var lastNameTxt: TextField
        lateinit var birthDateDatePick: DatePicker

        fieldset("Personal info") {
            field("First name:") {
                firstNameTxt = textfield { id = "firstNameTxt" }
            }
            field("Last name:") {
                lastNameTxt = textfield { id = "lastNameTxt" }
            }
            field("Birthday:") {
                birthDateDatePick = datepicker()
            }
        }
        button("Save") {
            action {
                println("${firstNameTxt.text} ${lastNameTxt.text}, born at ${birthDateDatePick.value} was saved!!!!")
            }
        }
    }
}

fun main(args: Array<String>) {
    Application.launch(MyApp::class.java, *args)
}
