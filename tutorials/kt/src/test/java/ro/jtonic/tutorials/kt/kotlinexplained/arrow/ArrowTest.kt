package ro.jtonic.tutorials.kt.kotlinexplained.arrow

import arrow.core.None
import arrow.core.Option
import arrow.core.Some
import arrow.core.Try
import arrow.core.fix
import arrow.core.monad
import arrow.typeclasses.binding
import io.kotlintest.matchers.beOfType
import io.kotlintest.matchers.should
import io.kotlintest.matchers.shouldBe
import org.junit.Test

/**
 * Created by Antonel Ernest Pazargic on 06/04/2018.
 * @author Antonel Ernest Pazargic
 */
class ArrowTest {

    @Test
    fun `with arrow Option`() {

        fun length(str: String?): Option<Int> = if (str == null) None else Some(str.length)

        // arrow Option is a Monad, so, we can use its flatMap implementation.
        // this is ugly, isn't it
        fun length(str1: String?, str2: String?): Option<Int> =
                length(str1).flatMap {
                    l1 -> length(str2).flatMap {
                        l2 -> Some(l1 + l2)
                    }
                }

        var a1: String? = null
        var a2: String? = "123"
        length(a1, a2) shouldBe None

        a1 = "123"
        a2 = "45"
        length(a1, a2).let {
            it should beOfType<Some<Int>>()
            (it as Some<Int>).t shouldBe 5
        }
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
