package ro.jtonic.tutorials.kt.ui.dictionary.di

import org.koin.core.parameter.ParameterDefinition
import org.koin.core.parameter.emptyParameterDefinition
import org.koin.standalone.StandAloneContext

/**
 * Koin component
 */
interface Injectable

/**
 * inject lazily given dependency for KoinComponent
 * @param name - bean name / optional
 */
inline fun <reified T: Any> Injectable.autowire(name: String = "", noinline parameters: ParameterDefinition = emptyParameterDefinition()) =
    kotlin.lazy { StandAloneContext.getKoin().koinContext.get<T>(name = name, parameters = parameters) }

/**
 * inject lazily given property for KoinComponent
 * @param key - key property
 * throw MissingPropertyException if property is not found
 */
inline fun <reified T> Injectable.property(key: String) =
    kotlin.lazy { StandAloneContext.getKoin().koinContext.getProperty<T>(key) }

/**
 * inject lazily given property for KoinComponent
 * give a default value if property is missing
 *
 * @param key - key property
 * @param defaultValue - default value if property is missing
 *
 */
inline fun <reified T> Injectable.property(key: String, defaultValue: T) =
    kotlin.lazy { StandAloneContext.getKoin().koinContext.getProperty(key, defaultValue) }


/**
 * Help to Access context
 */
private fun context() = StandAloneContext.getKoin().koinContext

/**
 * Retrieve given dependency for KoinComponent
 * @param name - bean name / optional
 */
inline fun <reified T: Any> Injectable.get(name: String = "", noinline parameters: ParameterDefinition = emptyParameterDefinition()) =
    StandAloneContext.getKoin().koinContext.get<T>(name = name, parameters = parameters)

/**
 * Retrieve given property for KoinComponent
 * @param key - key property
 * throw MissingPropertyException if property is not found
 */
inline fun <reified T> Injectable.getProperty(key: String) =
    StandAloneContext.getKoin().koinContext.getProperty<T>(key)

/**
 * Retrieve given property for KoinComponent
 * give a default value if property is missing
 *
 * @param key - key property
 * @param defaultValue - default value if property is missing
 *
 */
inline fun <reified T> Injectable.getProperty(key: String, defaultValue: T) =
    StandAloneContext.getKoin().koinContext.getProperty(key, defaultValue)

/**
 * set a property
 * @param key
 * @param value
 */
fun Injectable.setProperty(key: String, value: Any) = context().setProperty(key, value)

/**
 * Release a Koin context
 * @param name
 */
fun Injectable.releaseContext(name: String) = context().release(name)

/**
 * Release properties
 * @param keys - key properties
 */
//fun Injectable.releaseProperties(vararg keys: String) = context().release(*keys)
