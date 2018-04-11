@file:JvmName("DictionaryAppMain")

package ro.jtonic.tutorials.kt.ui.dictionary.app

import javafx.application.Application
import javafx.stage.Stage
import ro.jtonic.tutorials.kt.ui.dictionary.css.Style
import ro.jtonic.tutorials.kt.ui.dictionary.exception.AppErrorHandler
import ro.jtonic.tutorials.kt.ui.dictionary.view.MainWorkspace
import tornadofx.*

/**
 * Created by Antonel Ernest Pazargic on 24/12/2017.
 * @author Antonel Ernest Pazargic
 */
class DictionaryApp : App(MainWorkspace::class, Style::class) {

    init {
        Rest.useApacheHttpClient()
        Thread.setDefaultUncaughtExceptionHandler(AppErrorHandler())
    }

    override fun start(stage: Stage) {
        super.start(stage)
        stage.run {
            height = 600.0
            width = 800.0
            centerOnScreen()
            isAlwaysOnTop = false
            isFullScreen = false
            isIconified = false
        }
        stage.isAlwaysOnTop = true
    }
}

fun main(args: Array<String>) {
    Application.launch(DictionaryApp::class.java, *args)
}
