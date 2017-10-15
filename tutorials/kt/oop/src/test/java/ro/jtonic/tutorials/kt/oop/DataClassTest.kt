package ro.jtonic.tutorials.kt.oop

import io.kotlintest.matchers.shouldBe
import org.junit.Test
import ro.jtonic.tutorials.kt.model.Person

/**
 * Created by Antonel Ernest Pazargic on 15/10/2017.
 * @author Antonel Ernest Pazargic
 */
class DataClassTest {

    @Test
    fun `data class simple example`() {
        val person1 = Person("Antonel", "Pazargic", 47)
        person1.age shouldBe 47

        val person2 = person1.copy(age = person1.age + 1)
        person1.age shouldBe 47
        person2.age shouldBe 48
        person2.firstName shouldBe person1.firstName
    }
}