@file:JvmName("DictionaryAppMain")

package ro.jtonic.tutorials.kt.ui.dictionary.app

import javafx.application.Application
import javafx.stage.Stage
import org.koin.standalone.StandAloneContext.closeKoin
import org.koin.standalone.StandAloneContext.startKoin
import ro.jtonic.tutorials.kt.ui.dictionary.css.Style
import ro.jtonic.tutorials.kt.ui.dictionary.di.HelloModule
import ro.jtonic.tutorials.kt.ui.dictionary.exception.AppErrorHandler
import ro.jtonic.tutorials.kt.ui.dictionary.model.Configuration
import ro.jtonic.tutorials.kt.ui.dictionary.model.ConfigurationModel
import ro.jtonic.tutorials.kt.ui.dictionary.model.Property.WHO
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
        setUserAgentStylesheet(STYLESHEET_MODENA)
        this.configModel
    }
}

internal val App.configModel: ConfigurationModel 
    get() {
        return ConfigurationModel(Configuration(config.string(Configuration.C_KEY, "ws31wx")))
    }

fun main(args: Array<String>) {
    startKoin(listOf(HelloModule), properties = mapOf(WHO to "jtonic"))
    Application.launch(DictionaryApp::class.java, *args)
    closeKoin()
}
