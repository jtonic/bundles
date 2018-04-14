package ro.jtonic.tutorials.kt.kotlinexplained.arrow

import arrow.core.toT
import arrow.syntax.tuples.plus
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
}
