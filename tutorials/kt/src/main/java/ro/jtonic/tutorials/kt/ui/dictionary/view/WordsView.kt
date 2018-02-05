package ro.jtonic.tutorials.kt.ui.dictionary.view

import javafx.scene.control.DatePicker
import javafx.scene.control.TextField
import tornadofx.*

class WordsView : View() {

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