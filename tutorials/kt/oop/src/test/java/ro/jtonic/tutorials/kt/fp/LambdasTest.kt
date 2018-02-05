package ro.jtonic.tutorials.kt.fp

import io.kotlintest.matchers.haveSize
import io.kotlintest.matchers.should
import io.kotlintest.matchers.shouldBe
import org.junit.Test

/**
 * Created by Antonel Ernest Pazargic on 03/02/2018.
 * @author Antonel Ernest Pazargic
 */

class LambdasTest {

    @Test
    fun `simplified lambdas in kotlin`() {

        val doubled = { i: Int -> 2 * i }

        val doubledFun: Function1<Int, Int> = doubled

        doubledFun(2) shouldBe 4

        val result = mapOf(1 to "one", 2 to "two").map { (k, _) -> k + 1 }

        result shouldBe listOf(2, 3)

        result.filter { it > 2 } should haveSize(1)

        var sum: (Int, Int) -> Int = { a, b -> a + b }

        sum(1, 2) shouldBe 3

        sum = ::sumMethod

        sum(2, 2) shouldBe 4
    }

    private fun sumMethod(a: Int, b: Int) = a + b
}