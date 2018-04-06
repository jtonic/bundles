package ro.jtonic.tutorials.kt.kotlinexplained.arrow

import arrow.syntax.function.forwardCompose
import io.kotlintest.matchers.shouldBe
import org.junit.Test

/**
 * Created by Antonel Ernest Pazargic on 06/04/2018.
 * @author Antonel Ernest Pazargic
 */

class ArrowTest {

    @Test
    fun `test andThen`() {

        fun inc(a: Int) = a + 1
        fun format(a: Int) = "Result: $a"
        fun printResult(result: String) = println(result)

        (::inc forwardCompose ::format)(2) shouldBe "Result: 3"

        (::inc forwardCompose ::format forwardCompose ::printResult)(2)
     }
}
