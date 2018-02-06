package ro.jtonic.tutorials.kt.ui.dictionary.controller

import javafx.scene.control.Label
import tornadofx.*

/**
 * Created by Antonel Ernest Pazargic on 06/02/2018.
 * @author Antonel Ernest Pazargic
 */
class WordController : Controller() {

    private val api: Rest by inject()

    init {
        // Configuring the client
        api.baseURI = "https://od-api.oxforddictionaries.com:443/api/v1/entries/en"
        api.engine.requestInterceptor = {
            val request = (it as HttpClientRequest).request
            request.addHeader("app_id", "95aa7f87")
            request.addHeader("app_key", "f4537d70a1677e67eea48ba76d070fc0")
            request.addHeader("Content-Type", "application/json")
        }
    }


    fun getAT(msg: String, lbl: Label) {
        val response = api.get("deaf")
        try {
            val translated = when {
                response.ok() -> response.text()
                else -> "nothing!!!"
            }
            lbl.text = translated
        } finally {
            response.consume()
        }
    }
}