package ro.jtonic.tutorials.kt.ui.dictionary.di

import org.koin.KoinContext
import org.koin.core.parameter.Parameters
import org.koin.standalone.StandAloneContext

/**
 * Koin component
 */
interface Injectable

/**
 * inject lazily given dependency for KoinComponent
 * @param name - bean name / optional
 */
inline fun <reified T> Injectable.autowire(name: String = "", noinline parameters: Parameters = { emptyMap() }) =
    kotlin.lazy { (StandAloneContext.koinContext as KoinContext).get<T>(name, parameters) }

/**
 * inject lazily given property for KoinComponent
 * @param key - key property
 * throw MissingPropertyException if property is not found
 */
inline fun <reified T> Injectable.property(key: String) =
    kotlin.lazy { (StandAloneContext.koinContext as KoinContext).getProperty<T>(key) }

/**
 * inject lazily given property for KoinComponent
 * give a default value if property is missing
 *
 * @param key - key property
 * @param defaultValue - default value if property is missing
 *
 */
inline fun <reified T> Injectable.property(key: String, defaultValue: T) =
    kotlin.lazy { (StandAloneContext.koinContext as KoinContext).getProperty(key, defaultValue) }


/**
 * Help to Access context
 */
private fun context() = (StandAloneContext.koinContext as KoinContext)

/**
 * Retrieve given dependency for KoinComponent
 * @param name - bean name / optional
 */
inline fun <reified T> Injectable.get(name: String = "", noinline parameters: Parameters = { emptyMap() }) =
    (StandAloneContext.koinContext as KoinContext).get<T>(name, parameters)

/**
 * Retrieve given property for KoinComponent
 * @param key - key property
 * throw MissingPropertyException if property is not found
 */
inline fun <reified T> Injectable.getProperty(key: String) =
    (StandAloneContext.koinContext as KoinContext).getProperty<T>(key)

/**
 * Retrieve given property for KoinComponent
 * give a default value if property is missing
 *
 * @param key - key property
 * @param defaultValue - default value if property is missing
 *
 */
inline fun <reified T> Injectable.getProperty(key: String, defaultValue: T) =
    (StandAloneContext.koinContext as KoinContext).getProperty(key, defaultValue)

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
fun Injectable.releaseContext(name: String) = context().releaseContext(name)

/**
 * Release properties
 * @param keys - key properties
 */
fun Injectable.releaseProperties(vararg keys: String) = context().releaseProperties(*keys)
