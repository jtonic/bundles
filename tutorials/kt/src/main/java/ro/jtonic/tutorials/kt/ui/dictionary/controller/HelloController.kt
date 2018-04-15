package ro.jtonic.tutorials.kt.ui.dictionary.controller

import ro.jtonic.tutorials.kt.ui.dictionary.di.Injectable
import ro.jtonic.tutorials.kt.ui.dictionary.di.injected
import ro.jtonic.tutorials.kt.ui.dictionary.service.HelloService
import tornadofx.*

/**
 * Created by Antonel Ernest Pazargic on 06/02/2018.
 * @author Antonel Ernest Pazargic
 */
class HelloController : Controller(), Injectable {

    private val helloService: HelloService by injected()

    fun hello() {

        println(helloService.hello())
    }
}
