package ro.jtonic.tutorials.kt.tutorials.funktionale

import arrow.core.andThen
import io.kotlintest.matchers.shouldBe
import org.junit.Test

/**
 * Created by Antonel Ernest Pazargic on 11/02/2018.
 * @author Antonel Ernest Pazargic
 */
class CompositionTest {

    @Test
    fun `simple composition`() {
        fun foo1(input: String): String = "one $input"
        fun foo2(input: String): Int = input.length

        (::foo1 andThen ::foo2)("1") shouldBe 5
    }
}