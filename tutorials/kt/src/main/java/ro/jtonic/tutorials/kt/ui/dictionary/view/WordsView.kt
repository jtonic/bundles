package ro.jtonic.tutorials.kt.ui.dictionary.view

import javafx.geometry.Orientation
import javafx.scene.control.DatePicker
import javafx.scene.control.Label
import javafx.scene.control.TextField
import ro.jtonic.tutorials.kt.ui.dictionary.controller.WordController
import ro.jtonic.tutorials.kt.ui.dictionary.view.Style.Companion.appSizeRule
import tornadofx.*

class WordsView : View("Dictionary") {
    private var firstNameTxt: TextField by singleAssign()
    private var lastNameTxt: TextField by singleAssign()
    private var birthDateDatePick: DatePicker by singleAssign()
    private var resultLbl: Label by singleAssign()
    private val controller: WordController = WordController()

    override
    val root = form {

        addClass(appSizeRule)
        fieldset("Personal info") {
            field("First name:", Orientation.VERTICAL) {
                firstNameTxt = textfield { id = "firstNameTxt" }
            }
            field("Last name:") {
                lastNameTxt = textfield { id = "lastNameTxt" }
            }
            field("Birthday:") {
                birthDateDatePick = datepicker()
            }
            resultLbl = label(text = "Nothing yet")
        }
        buttonbar {
            button("Save") {
                action {
                    runAsync {
                        val result = "${firstNameTxt.text} ${lastNameTxt.text}, born at ${birthDateDatePick.value} was saved!!!!"
                        println(result)
                        ui {
                            resultLbl.text = result
                            controller.getAT(result, resultLbl)
                        }
                    }
                }
            }
        }
    }
}
