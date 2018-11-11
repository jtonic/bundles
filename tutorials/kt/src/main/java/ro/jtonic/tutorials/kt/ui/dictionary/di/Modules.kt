package ro.jtonic.tutorials.kt.ui.dictionary.di

import org.koin.dsl.module.module
import ro.jtonic.tutorials.kt.ui.dictionary.model.HelloModel
import ro.jtonic.tutorials.kt.ui.dictionary.model.Property.WHO
import ro.jtonic.tutorials.kt.ui.dictionary.service.HelloService
import ro.jtonic.tutorials.kt.ui.dictionary.service.HelloServiceImpl

val HelloModule = module {
    single { HelloModel(getProperty(WHO)) }
    single { HelloServiceImpl(get()) as HelloService }
}
