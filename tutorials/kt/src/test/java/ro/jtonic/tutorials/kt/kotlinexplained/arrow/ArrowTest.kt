package ro.jtonic.tutorials.kt.kotlinexplained.arrow

import arrow.syntax.function.curried
import arrow.syntax.function.pipe
import io.kotlintest.matchers.shouldBe
import org.junit.Test

/**
 * Created by Antonel Ernest Pazargic on 06/04/2018.
 * @author Antonel Ernest Pazargic
 */

class ArrowTest {

    fun sum(a: Int, b: Int = 1) = a + b
    fun format(a: Int) = "$a"

    @Test
    fun `test andThen`() {
        val inc = ::sum.curried()(1)
        2 pipe inc pipe ::format shouldBe "3"
    }

}
