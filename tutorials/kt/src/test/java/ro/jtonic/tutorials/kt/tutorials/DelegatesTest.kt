package ro.jtonic.tutorials.kt.tutorials

import io.kotlintest.matchers.shouldBe
import io.kotlintest.matchers.shouldNotBe
import org.junit.Test
import kotlin.properties.Delegates

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

    class Student(val name: String, val age: Int = 5)
}

