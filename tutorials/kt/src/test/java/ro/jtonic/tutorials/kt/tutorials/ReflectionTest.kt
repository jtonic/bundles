package ro.jtonic.tutorials.kt.tutorials

import io.kotlintest.matchers.shouldBe
import org.junit.Test
import kotlin.reflect.KCallable
import kotlin.reflect.KMutableProperty1
import kotlin.reflect.full.createInstance
import kotlin.reflect.full.declaredMemberProperties
import kotlin.reflect.full.findParameterByName
import kotlin.reflect.full.primaryConstructor

/**
 * Created by Antonel Ernest Pazargic on 18/02/2018.
 * @author Antonel Ernest Pazargic
 */
class ReflectionTest {


    @Test
    fun `simple use of the call`() {
        val printIt: KCallable<Unit> = ::foo
        printIt.call("Antonel")
        //        printIt.call(2) // java.lang.IllegalArgumentException: argument type mismatch
    }

    @Test
    fun `simplified version of call using invoke`() {
        val printIt = ::foo
        printIt.invoke("Antonel")
    }


    @Test
    fun `test class properties`() {
        val jtonic = Person("Antonel", "Pazargic")
        val kclass = jtonic.javaClass.kotlin
        val properties = kclass.declaredMemberProperties
        val seq = properties.asSequence()
        seq.forEach {
            println(it)
        }
        val fNameProp: KMutableProperty1<Person, *> = seq.first { it.name == "fName" } as KMutableProperty1<Person, *>
        val fName = fNameProp.getter.call(jtonic) as String
        println("fName = $fName")
        val fName2 = fNameProp.get(jtonic) as String
        println("fName = $fName2")
        fNameProp.setter.call(jtonic, "Antonel de Romania")
        println("jtonic.fName = ${jtonic.fName}")
    }

    @Test
    fun `statically typed reflection`() {
        val fNameProp = Person::fName
        val jtonic = Person("Antonel", "Pazargic")
        val fName = fNameProp.get(jtonic)
        fName shouldBe jtonic.fName
        fNameProp.set(jtonic, "Brad Pitt de Romania")
        jtonic.fName shouldBe "Brad Pitt de Romania"
    }

    @Test
    fun `simple reflect example with dynamically instantiation of a class and its properties`() {


        val personKlass = Person::class
        val fNameProp = personKlass.declaredMemberProperties.first { it.name == "fName" }
        val lNameProp = personKlass.declaredMemberProperties.first { it.name == "lName" }

        val person = personKlass.createInstance()

        // setter has to be called when the type is unknown
        // on the other hand if the type is know (as in the case of Person::fName better use call because is type safe
        (fNameProp as KMutableProperty1<Person, *>).setter.call(person, "Brad")
        (lNameProp as KMutableProperty1<Person, *>).setter.call(person, "Pitt de Romania")

        person.fName shouldBe "Brad"
        person.lName shouldBe "Pitt de Romania"
    }

    @Test
    fun `create an instance of a data class using the primary constructor`() {
        val ctor = Student::class.primaryConstructor
        val fNameParam = ctor?.findParameterByName(Student::fName.name)
                ?: throw IllegalArgumentException()
        val lNameParam = ctor.findParameterByName(Student::lName.name)
                ?: throw IllegalArgumentException()
        val student = ctor.callBy(mapOf(lNameParam to "Pazargic", fNameParam to "Antonel"))

        with(student) {
            fName shouldBe "Antonel"
            lName shouldBe "Pazargic"
            age shouldBe 18
        }
    }

    data class Student(val fName: String, val lName: String, val age: Int = 18)
}

fun foo(msg: String) = println(msg)

data class Person(var fName: String?, var lName: String?) {

    constructor() : this(null, null)
}
