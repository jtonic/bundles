package ro.jtonic.tutorials.kt.oop.miscs

import io.kotlintest.matchers.should
import io.kotlintest.matchers.shouldBe
import io.kotlintest.matchers.shouldNotBe
import io.kotlintest.matchers.startWith
import org.junit.Test

class MiscsTest {

    @Test
    fun `let also`() {

        var a: String? = null
        a?.let { println("This is not null") }

        a = "Antonel"
        a?.let { println("This is not null. $it") }
    }

    @Test
    fun `nullable tests`() {
        val a1: String? = null
        val a2 = a1 ?: ""

        a2 shouldBe ""

        val a3 = a1?.let { println("a1 is not null"); a1.reversed() }
        a3 shouldBe null

        val a4 = "jtonic"

        val a5 = a4?.let {
            println("a4 is not null")
            a4.reversed()
        }

        a5 shouldBe a4.reversed()
    }

    @Test
    fun `primitive wrappers`() {
        val a: Int = 10
        val b: Long = 10
        a shouldNotBe b
        a shouldBe b.toInt()
    }

    @Test
    fun `array thingy`() {
        val arr = Array(5, { (it * it).toString() })
        arr.forEach(::println)
        arr[2] shouldBe 4.toString()
    }

    @Test
    fun `multiline string`() {
        val str = """Antonel
            |is the best programmer
            |ever
            |in Bucharest.
            |Despite this obvious thing it gain only ${'$'}1/hour""".trimMargin()
        println(str)
        str should startWith("Antonel\nis the best programmer")
    }
}