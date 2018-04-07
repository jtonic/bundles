package ro.jtonic.tutorials.kt.kotlinexplained.arrow

import arrow.syntax.function.bind
import io.kotlintest.matchers.beOfType
import io.kotlintest.matchers.shouldBe
import io.kotlintest.matchers.shouldNot
import io.kotlintest.matchers.shouldNotBe
import org.junit.Test

/**
 * Created by Antonel Ernest Pazargic on 06/04/2018.
 * @author Antonel Ernest Pazargic
 */

class ArrowTest {

    fun strong(str: String) = "<strong>$str</strong>"

    @Test
    fun `test binding`() {

        val antonelStrong = ::strong.bind("Antonel")
        antonelStrong shouldNotBe "<strong>Antonel</strong>"
        antonelStrong shouldNot beOfType<String>()

        antonelStrong() shouldBe "<strong>Antonel</strong>"
    }
}
