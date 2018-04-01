package ro.jtonic.tutorials.kt.ui.dictionary.view

import javafx.beans.property.SimpleStringProperty
import javafx.geometry.Orientation
import javafx.scene.control.DatePicker
import javafx.scene.control.Label
import javafx.scene.control.TextField
import ro.jtonic.tutorials.kt.ui.dictionary.controller.WordController
import ro.jtonic.tutorials.kt.ui.dictionary.css.Style
import ro.jtonic.tutorials.kt.ui.dictionary.css.Style.Companion.viewBgColor
import ro.jtonic.tutorials.kt.ui.dictionary.css.Style.Companion.wrapper
import tornadofx.*

class WordsView : View("Dictionary") {
    private var firstNameTxt: TextField by singleAssign()
    private var lastNameTxt: TextField by singleAssign()
    private var birthDateDatePick: DatePicker by singleAssign()
    private var resultLbl: Label by singleAssign()
    private val controller: WordController by inject()

    private val itemsGlobal = listOf("Antonel", "Irina", "Roxana", "Liviu", "Bogdan")
    private val selectedItem = SimpleStringProperty(itemsGlobal.first())

    private val mainView: MainView by inject()

    override
    val root = borderpane {
        top {
            menubar {
                menu("Help") {
                    item("About", "Shortcut+A").action {
                        println("About!!!")
                    }
                }
            }
        }
        center {
            squeezebox {
                style {
                    backgroundColor += c("#B2EBFF")
                }
                fold(title = "Penetration tests", expanded = true, closeable = false) {
                    addClass(Style.viewBgColor)
                    form {
                        addClass(wrapper, viewBgColor)
                        useMaxHeight = true
                        useMaxWidth = true
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
                            field("Person") {
                                combobox(selectedItem, itemsGlobal) {
                                    makeAutocompletable()
                                    isEditable = false
                                }
                            }


                            resultLbl = label(text = "Nothing yet")

                        }
                        buttonbar {
                            button("Save") {
                                addClass(Style.buttonFaceColor)
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
                fold("Simple example") {
                    addClass(Style.viewBgColor)
                    log.info("simple example...")
                    content = mainView.root
                }
            }
        }
        bottom {
            hbox {
                addClass(Style.statusBarFace)
                label {
                    text = ""
                }
            }
        }
    }
}
