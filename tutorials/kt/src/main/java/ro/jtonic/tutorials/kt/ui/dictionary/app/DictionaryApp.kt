package ro.jtonic.tutorials.kt.ui.dictionary.app

import javafx.application.Application
import ro.jtonic.tutorials.kt.ui.dictionary.view.Style
import ro.jtonic.tutorials.kt.ui.dictionary.view.WordsView
import tornadofx.*

/**
 * Created by Antonel Ernest Pazargic on 24/12/2017.
 * @author Antonel Ernest Pazargic
 */
class DictionaryApp : App(WordsView::class, Style::class) {
    init {
        Rest.useApacheHttpClient()
    }
}

fun main(args: Array<String>) {
    Application.launch(DictionaryApp::class.java, *args)
}
