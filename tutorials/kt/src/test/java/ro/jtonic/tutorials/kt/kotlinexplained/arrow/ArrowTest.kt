package ro.jtonic.tutorials.kt.kotlinexplained.arrow

import arrow.core.Try
import arrow.core.fix
import arrow.core.monad
import arrow.typeclasses.binding
import io.kotlintest.matchers.shouldBe
import org.junit.Test

/**
 * Created by Antonel Ernest Pazargic on 06/04/2018.
 * @author Antonel Ernest Pazargic
 */

class ArrowTest {

    @Test
    fun `without arrow Option`() {

        // using kotlin nullable types
        fun length(str: String?): Int? = str?.length

        var a: String? = null
        length(a) shouldBe null

        a = "123"
        length(a) shouldBe 3
    }

    @Test
    fun `composition of pure and inpure functions`() {

        fun pure1(i: Int) = i + 1

        fun inpure2(i: Int): Try<Int> {
            return Try.Success(i + 1)
        }

        val pure3 = ::pure1

        fun pure4(i: Int) = i + 1

        Try.monad().binding {
            val v1 = pure1(1)
            val v2 = inpure2(v1).bind()
            val v3 = pure3(v2)
            val result = pure4(v3)
            result
        }.fix().fold({ -1 }, { it }) shouldBe 5
    }
}
