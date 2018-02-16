package ro.jtonic.tutorials.kt.ui.dictionary.app

import javafx.application.Application
import ro.jtonic.tutorials.kt.ui.dictionary.css.Style
import ro.jtonic.tutorials.kt.ui.dictionary.view.MainView
import tornadofx.*

/**
 * Created by Antonel Ernest Pazargic on 24/12/2017.
 * @author Antonel Ernest Pazargic
 */
class DictionaryApp : App(MainView::class, Style::class) {
    init {
        Rest.useApacheHttpClient()
    }
}

fun main(args: Array<String>) {
    Application.launch(DictionaryApp::class.java, *args)
}
