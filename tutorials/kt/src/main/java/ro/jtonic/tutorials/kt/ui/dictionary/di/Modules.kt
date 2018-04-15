package ro.jtonic.tutorials.kt.ui.dictionary.di

import org.koin.dsl.module.applicationContext
import ro.jtonic.tutorials.kt.ui.dictionary.model.HelloModel
import ro.jtonic.tutorials.kt.ui.dictionary.model.Property.WHO
import ro.jtonic.tutorials.kt.ui.dictionary.service.HelloService
import ro.jtonic.tutorials.kt.ui.dictionary.service.HelloServiceImpl

val HelloModule = applicationContext {
    bean { HelloModel(getProperty(WHO)) }
    bean { HelloServiceImpl(get()) as HelloService }
}
