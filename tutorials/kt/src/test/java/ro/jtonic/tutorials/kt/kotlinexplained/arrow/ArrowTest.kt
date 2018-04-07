package ro.jtonic.tutorials.kt.kotlinexplained.arrow

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

        val sumAndFormat = ::sum andThen ::format
        sumAndFormat(1, 2) shouldBe "3"
    }

    infix fun <A, B, C, D> ((A, B) -> C).andThen(f: (C) -> D): (A, B) -> D = { a, b -> f(this(a, b)) }
}
