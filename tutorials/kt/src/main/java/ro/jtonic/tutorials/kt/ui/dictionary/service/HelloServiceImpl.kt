package ro.jtonic.tutorials.kt.ui.dictionary.service

import ro.jtonic.tutorials.kt.ui.dictionary.model.HelloModel

class HelloServiceImpl(private val helloModel: HelloModel) : HelloService {

    override fun hello() =
            "Hello ${helloModel.who}"
}
