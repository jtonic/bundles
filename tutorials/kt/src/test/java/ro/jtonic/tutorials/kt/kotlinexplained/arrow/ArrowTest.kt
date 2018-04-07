package ro.jtonic.tutorials.kt.kotlinexplained.arrow

import arrow.syntax.function.invoke
import arrow.syntax.function.pipe
import io.kotlintest.matchers.shouldBe
import org.junit.Test

/**
 * Created by Antonel Ernest Pazargic on 06/04/2018.
 * @author Antonel Ernest Pazargic
 */

class ArrowTest {

    fun sum(a: Int, b: Int = 1) = a + b
    fun format(a: Int) = "Result: $a"

    @Test
    fun `test andThen`() {

        fun incBy(by: Int) = (::sum)(p2 = by)
        2 pipe ::incBy pipe ::format shouldBe "Result: 3"
    }
}
