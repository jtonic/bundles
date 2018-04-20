package ro.jtonic.tutorials.kt.kotlinexplained.arrow

import arrow.core.toT
import arrow.data.Success
import arrow.data.Try
import arrow.data.ev
import arrow.data.monad
import arrow.syntax.tuples.plus
import arrow.typeclasses.binding
import io.kotlintest.matchers.shouldBe
import org.junit.Test

/**
 * Created by Antonel Ernest Pazargic on 06/04/2018.
 * @author Antonel Ernest Pazargic
 */

typealias Age = Int
typealias SiblingsNo = Int
typealias Salary = Int

class ArrowTest {

    @Test
    fun `the beauty of working with arrow TupleX`() {

        val salary: Salary = 100_000
        val age: Age = 48
        val siblingsNo: SiblingsNo = 3

        val t2 = "Antonel" toT salary

        val t3 = t2 + age
        val t4 = t3 + siblingsNo

        t2.run { a shouldBe "Antonel"; b shouldBe salary }
        t3.c shouldBe age
        t4.d shouldBe siblingsNo

    }

    @Test
    fun `composition of pure and inpure functions`() {

        fun pure1(i: Int) = i + 1

        fun inpure2(i: Int) : Try<Int> {
            return Success(i + 1)
        }

        val pure3 = ::pure1

        fun pure4(i: Int) = i + 1

        Try.monad().binding {
            val v1 = pure1(1)
            val v2 = inpure2(v1).bind()
            val v3 = pure3(v2)
            val result = pure4(v3)
            result
        }.ev().fold( { -1 }, { it } ) shouldBe 5
    }
}
