package ro.jtonic.tutorials.kt.tutorials.funktionale

import arrow.core.Failure
import arrow.core.Success
import arrow.core.Try
import arrow.core.getOrElse
import io.kotlintest.fail
import io.kotlintest.matchers.beOfType
import io.kotlintest.should
import io.kotlintest.shouldBe
import org.junit.Test

/**
 * Created by Antonel Ernest Pazargic on 17/12/2017.
 * @author Antonel Ernest Pazargic
 */
class TryTest {

    @Test
    fun `simple usage of Try`() {

        val lst = emptyList<Int>()
        val result = Try {
            val (first) = lst
            first
        }
        when (result) {
            is Success -> {
                fail("This should not happen")
            }
            is Failure -> {
                result.exception should beOfType<IndexOutOfBoundsException>()
            }
        }
    }

    @Test
    fun `simple usage of Try with method reference`() {

        val lst = emptyList<Int>()
        Try(::getFirstElement).getOrElse { -1 } shouldBe -1
    }

    private fun getFirstElement(): Int {
        val lst = emptyList<Int>()
        val (first) = lst
        return first
    }
}
