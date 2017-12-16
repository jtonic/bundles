package ro.jtonic.tutorials.kt.tutorials.funktionale

import io.kotlintest.matchers.shouldBe
import org.funktionale.composition.andThen
import org.funktionale.currying.curried
import org.funktionale.pairing.paired
import org.funktionale.pairing.unpaired
import org.junit.Test

/**
 * Created by Antonel Ernest Pazargic on 16/12/2017.
 * @author Antonel Ernest Pazargic
 */
class FunctionsCompositionTest {


    @Test
    fun `compose the result of a sum with a multiply applying currying`() {
        val add2Ints = {a: Int, b: Int -> a + b}
        val multiply = {a: Int, b: Int -> a * b}
        val add5 = add2Ints.curried()(5)

        val multiplyBy2 = multiply.curried()(2)
        val add5andMultiplyBy2 = add5 andThen multiplyBy2 // add5 andThen multiplyBy2
        add5andMultiplyBy2(2) shouldBe 14
    }

    @Test
    fun `paired unpaired`() {
        val sum = { a: Int, b: Int -> a + b }
        val paired = sum.paired()
        paired(1 to 2) shouldBe sum(1, 2)

        val unpaired = paired.unpaired()
        unpaired(1, 2) shouldBe sum(1, 2)
    }
}