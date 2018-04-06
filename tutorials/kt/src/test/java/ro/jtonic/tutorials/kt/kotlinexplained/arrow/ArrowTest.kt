package ro.jtonic.tutorials.kt.kotlinexplained.arrow

import arrow.syntax.function.andThen
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

        (::inc andThen ::format)(2) shouldBe "Result: 3"

        (::inc andThen ::format andThen ::printResult)(2)
     }
}
