package ro.jtonic.tutorials.kt.kotlinexplained.arrow

import arrow.syntax.function.complement
import arrow.syntax.function.pipe
import io.kotlintest.matchers.shouldBe
import org.junit.Test

/**
 * Created by Antonel Ernest Pazargic on 06/04/2018.
 * @author Antonel Ernest Pazargic
 */

class ArrowTest {

    @Test
    fun `test complement`() {

        val even: (Int) -> Boolean = { it % 2 == 0}
        10 pipe even shouldBe true

        11 pipe even.complement() shouldBe true
    }
}
