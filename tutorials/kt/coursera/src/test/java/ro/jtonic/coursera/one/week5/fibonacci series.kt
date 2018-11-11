package ro.jtonic.coursera.one.week5

import io.kotlintest.shouldBe
import org.junit.Test

class Week5Test {

    @Test
    fun `fibonacci series`() {

        val fibonacciSeq: Sequence<Int> = sequence {
            var elements = 0 to 1
            while (true) {
                yield(elements.first)
                elements = elements.second to (elements.first + elements.second)
            }
        }

        val fib1 = fibonacciSeq.take(7).toList()
        fib1 shouldBe listOf(0, 1, 1, 2, 3, 5, 8)

        val fib2 = fibonacciSeq.take(10).toList().joinToString()
        println("fib2 = $fib2")
    }

}
