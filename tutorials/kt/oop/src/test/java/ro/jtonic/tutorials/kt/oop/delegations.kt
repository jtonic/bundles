package ro.jtonic.tutorials.kt.oop

import io.kotlintest.matchers.shouldBe
import org.junit.Test
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/**
 * Created by Antonel Ernest Pazargic on 15/10/2017.
 * @author Antonel Ernest Pazargic
 */
class DelegationTest {

    @Test
    fun `simple delegated property`() {
        val foo = Person("Antonel Ernest", "Pazargic")
        foo.name shouldBe "Antonel Ernest Pazargic"
        foo.age shouldBe 48
        foo.age = 49
        foo.age shouldBe 49
    }
}

class Person(private val fName: String, private val lName: String) {
    val name: String
        get() {
            return "$fName $lName"
        }
    var age: Int by wired
}

val wired: AgeDelegate
    get() = AgeDelegate(48)

class AgeDelegate(private var propValue: Int) : ReadWriteProperty<Person, Int> {

    override fun getValue(thisRef: Person, property: KProperty<*>): Int {
        return propValue
    }

    override fun setValue(thisRef: Person, property: KProperty<*>, value: Int) {
        println("$value has been assigned to '${property.name} in $thisRef.'")
        propValue = value
    }
}


