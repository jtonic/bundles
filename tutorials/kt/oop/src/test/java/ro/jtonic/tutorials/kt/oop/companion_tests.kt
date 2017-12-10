package ro.jtonic.tutorials.kt.oop

import io.kotlintest.matchers.shouldBe
import org.junit.Test

/**
 * Created by Antonel Ernest Pazargic on 17/10/2017.
 * @author Antonel Ernest Pazargic
 */

class User {

    private lateinit var name: String

    override fun toString() = name

    companion object {
        @JvmStatic
        val instance by lazy {
            User().apply { name = "jtonic" }
        }
    }
}

class CompanionTest {

    @Test
    fun `test companion object`() {
        User.instance.toString() shouldBe "jtonic"
    }
}