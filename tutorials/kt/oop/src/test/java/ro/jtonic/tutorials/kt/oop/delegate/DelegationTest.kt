package ro.jtonic.tutorials.kt.oop.delegate

import io.kotlintest.shouldBe
import org.junit.Test

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
