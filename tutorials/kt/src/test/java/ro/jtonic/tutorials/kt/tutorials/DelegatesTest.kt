package ro.jtonic.tutorials.kt.tutorials

import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import io.kotlintest.shouldBe
import io.kotlintest.shouldNotBe
import org.junit.Test
import ro.jtonic.tutorials.core.Open
import kotlin.properties.Delegates
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KClass
import kotlin.reflect.KProperty
import kotlin.reflect.full.createInstance

/**
 * Created by Antonel Ernest Pazargic on 10/02/2018.
 * @author Antonel Ernest Pazargic
 */
class DelegatesTest {

    @Test
    fun `some simple delegates - vetoable and observable`() {
        var a: String by Delegates.observable("", onChange = { _, oldValue, newValue -> println("$oldValue -> $newValue") })
        a = "a"
        a = "b"


        var jtonic: Student by Delegates.vetoable(Student("Antonel"))
        { _, _, newValue ->
            if (newValue.age < 18) {
                println("The student should be at least 18 years old.")
                return@vetoable false
            }
            true
        }

        var ligia: Student by Delegates.vetoable(Student("Ligia", age = 4))
        { _, _, newValue ->
            if (newValue.age < 18) {
                println("The student should be at least 18 years old.")
                return@vetoable false
            }
            return@vetoable true
        }

        jtonic = Student("Antonel-Ernest", 27)
        jtonic.age shouldBe 27

        ligia = Student("Ligia Pazargic", 5)

        println("ligia = ${ligia.name} ${ligia.age}")

        ligia.age shouldNotBe 5
        ligia.name shouldNotBe "Ligia Pazargic"
    }

    @Test
    fun `custom delegate`() {
        class Injectable {
            val single: String by value()
        }
        val single = Injectable().single
        single shouldNotBe null
    }

    inline fun <reified T> value(params: Map<String, Any?>? = null): ReadOnlyProperty<Any, T> where T: Any = object : ReadOnlyProperty<Any, T> {
//        override fun getValue(thisRef: Any, property: KProperty<*>): T = create(T::class.java, params)
        override fun getValue(thisRef: Any, property: KProperty<*>): T = create(T::class, params)
    }

    fun <T : Any> create(type: KClass<T>, params: Map<*, Any?>?): T {
        val instance = type.createInstance()
        return instance
    }
/*
    fun <T : Any> create(type: java.lang.Class<T>, params: Map<*, Any?>?): T {
        val kclass = type.kotlin
        val instance = kclass.createInstance()
        return instance
    }
*/

    @Test
    fun `with mockito kotlin`() {
        val appCtx = mock<TestAppCtx>()
        whenever(appCtx.foo(any())).thenReturn("kkmk")

    }

    @Open
    class TestAppCtx {

        fun foo(a: String): String {
            return a
        }
    }

    class Student(val name: String, val age: Int = 5)
}
