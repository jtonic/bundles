package ro.jtonic.tutorials.kt.oop

import io.kotlintest.matchers.beInstanceOf
import io.kotlintest.matchers.beTheSameInstanceAs
import io.kotlintest.matchers.should
import io.kotlintest.matchers.shouldBe
import org.junit.Test

/**
 * Created by Antonel Ernest Pazargic on 03/03/2018.
 * @author Antonel Ernest Pazargic
 */
class ObjectTest {

    object Singleton {
        fun greeting(name: String) = "Hi, $name!"
    }

    @Test
    fun `test the singleton`() {
        val sinOne = Singleton
        val sinTwo = Singleton
        sinOne should beTheSameInstanceAs(sinTwo)

        val greeting = Singleton.greeting("Antonel")
        greeting shouldBe "Hi, Antonel!"
    }

    @Test
    fun `class properties`() {
        val grapeCake = Cake("grape")
        println("flavor: ${grapeCake.flavor}")
//        grapeCake.flavor = "blueberry" //throws compilation error: Error:(32, 9) Kotlin: Val cannot be reassigned
    }

    class Cake(flavor: Flavour) {

        val flavor = flavor
    }

    @Test
    fun `minimum common type in kotlin is different than in java`() {
        val name: String? = null
        val length = name?.length ?: 1.1
        length should beInstanceOf(Number::class)

        val length2: Number = name?.length ?: 1.1
        length shouldBe 1.1
    }
}

typealias Flavour = String

