package ro.jtonic.tutorials.kt.tutorials.funktionale

import arrow.syntax.function.andThen
import arrow.syntax.function.curried
import arrow.syntax.function.paired
import arrow.syntax.function.unpaired
import io.kotlintest.matchers.shouldBe
import org.junit.Test

/**
 * Created by Antonel Ernest Pazargic on 16/12/2017.
 * @author Antonel Ernest Pazargic
 */
class FunctionsCompositionTest {


    @Test
    fun `compose the result of a sum with a multiply applying currying`() {
        val add2Ints = { a: Int, b: Int -> a + b }
        val multiply = { a: Int, b: Int -> a * b }
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

    @Test
    fun `test curried with method reference`() {
        fun add2Ints(a: Int, b: Int) = a + b
        fun multiply(a: Int, b: Int) = a * b

        val add5 = ::add2Ints.curried()(5)
        val multiply2 = ::multiply.curried()(2)

        add5(5) shouldBe 10
        multiply2(5) shouldBe 10

        (add5 andThen multiply2)(5) shouldBe 20
    }

    @Test
    fun `a nice chain`() {
        fun config() = ConfigData()
        fun restCall(config: ConfigData): User {
            val user = User("antonel", config.role)
            println("Rest call. Getting the user: $user")
            return user
        }
        fun printToConsole(user: User) {
            println("user = $user")
        }
        (::config andThen ::restCall andThen ::printToConsole)()
    }

    class ConfigData {
        val role by lazy { "Admin" }
    }
    data class User(val userName: String, val role: String)
}