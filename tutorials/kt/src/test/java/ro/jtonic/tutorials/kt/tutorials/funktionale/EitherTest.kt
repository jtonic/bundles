package ro.jtonic.tutorials.kt.tutorials.funktionale

import arrow.core.Try
import arrow.legacy.disjunctionTry
import io.kotlintest.matchers.beOfType
import io.kotlintest.matchers.fail
import io.kotlintest.matchers.should
import io.kotlintest.matchers.shouldBe
import io.kotlintest.matchers.shouldThrow
import org.junit.Test

/**
 * Created by Antonel Ernest Pazargic on 17/12/2017.
 * @author Antonel Ernest Pazargic
 */
class EitherTest {

    @Test
    fun `without the either`() {
        val lst = emptyList<String>()

        shouldThrow<IndexOutOfBoundsException> {
            val (first, second) = lst
            println("first = $first, second = $second")
        }
    }

    @Test
    fun `get the first entry in a list with either`() {
        val lst = emptyList<String>()
        Try {
            getFirst2Values(lst)
        }.toEither().fold({
            it should beOfType<IndexOutOfBoundsException>()
        }) {
            fail("This shouldn't occurred")
        }
    }

    @Test
    fun `get the first entry in a list with disjunction`() {
        val lst = listOf(1, 2)

        disjunctionTry {
           getFirst2Values(lst)
        }.fold({}) {
            it.first shouldBe 1
            it.second shouldBe 2
        }
    }

    @Test
    fun `get the first entry in a list with disjunction - case 2`() {
        val lst = emptyList<Int>()

        val pair = disjunctionTry {
            getFirst2Values(lst)
        }.toOption().orNull()

        pair shouldBe null
    }

    private fun<T> getFirst2Values(lst: List<T>): Pair<T, T> =
         lst.component1() to lst.component2()
}
