package ro.jtonic.tutorials.kt.kotlinexplained.arrow

import arrow.syntax.function.partially2
import arrow.syntax.function.pipe
import io.kotlintest.matchers.shouldBe
import org.junit.Test

/**
 * Created by Antonel Ernest Pazargic on 06/04/2018.
 * @author Antonel Ernest Pazargic
 */

class ArrowTest {

    @Test
    fun `test andThen`() {

        fun sum(a: Int, b: Int = 1) = a + b
        val inc = ::sum.partially2(1)
        fun format(a: Int) = "Result: $a"

        2 pipe inc pipe ::format shouldBe "Result: 3"
    }
}
