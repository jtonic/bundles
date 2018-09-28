package ro.jtonic.tutorials.kt.kotlinexplained.scopefunctions

import io.kotlintest.matchers.beGreaterThan
import io.kotlintest.should
import io.kotlintest.shouldBe
import io.kotlintest.shouldNotBe
import org.junit.Test

/**
 * Created by Antonel Ernest Pazargic on 28/08/2018.
 * @author Antonel Ernest Pazargic
 */
class ScopeFunctionsTest {



    @Test
    fun `run with this`() {
        StringBuilder().run {
            this.append("jtonic")
        }
    }

    @Test
    fun `no nested with let and also`() {
        StringBuilder().run {
            shouldNotBe(null)
        }
    }

    @Test
    fun `nested let functions`() {
        StringBuilder().let {
            it.append("jtonic")
            it.append("is loving")
            it.append("kotlin")
            it.toString().let {
                it.toUpperCase()
            }.length should beGreaterThan(10)
        }
    }


    @Test
    fun `scope functions`() {

        "jtonic".run {
            length == 6
        } shouldBe true

        "jtonic".let {
            it.length == 6
        } shouldBe true

        "jtonic".apply {
            length == 6
        } shouldBe "jtonic"

        with("jtonic") {
            length == 6
        } shouldBe true

        "jtonic".run {
            toUpperCase()
        }.also {
            it.length == 6
        } shouldBe "JTONIC"

    }
}
