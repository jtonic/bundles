package ro.jtonic.tutorials.kt.kotlinexplained.arrow

import arrow.syntax.function.compose
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

        (::format compose ::inc)(2) shouldBe "Result: 3"

        (::printResult compose ::format compose ::inc)(2)
    }
}
