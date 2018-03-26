package ro.jtonic.tutorials.kt.tutorials.fp

import io.kotlintest.matchers.shouldBe
import org.junit.Test

/**
 * Created by Antonel Ernest Pazargic on 27/12/2017.
 * @author Antonel Ernest Pazargic
 */
class FunctionTest {

    @Test
    fun `calling a function implementation`() {


        val sum = SumFunction()
        sum(1, 2) shouldBe 3

    }

    @Test
    fun `call a function reference`() {
        val sumFun = ::sumFunction
        sumFun(2, 2) shouldBe 4
    }

    @Test
    fun `call a lambda reference`() {
        val sumLambda = { a: Int, b: Int -> a + b }
        sumLambda(3, 3) shouldBe 6

        val multiply: (Int) -> (Int) -> Int
        multiply = { a -> { b -> a * b } }
        multiply(3)(2) shouldBe 6

        // the following doesn't compile
        /*
                val getMessage = {response: Int ->
                    if (response in 500..599) {
                        return "Error"
                    }
                    return "ok"
                }
        */
        val getMessage = lambda@ { response: Int ->
            if (response in 500..599) {
                return@lambda "Error"
            }
            "ok"
        }
        getMessage(500) shouldBe "Error"
    }

    @Test
    fun `call anonymous function`() {
        val square: (x: Int) -> Int = fun(x) = x * x
        square(2) shouldBe 4

        val getMessage: (Int) -> String = fun(message: Int): String {
            if (message in 500..599) {
                return "Error"
            }
            return "Ok"
        }
        getMessage(300) shouldBe "Ok"
    }

}

class SumFunction : (Int, Int) -> Int {
    override fun invoke(p1: Int, p2: Int): Int {
        return p1 + p2
    }
}

fun sumFunction(a: Int, b: Int) = a + b

