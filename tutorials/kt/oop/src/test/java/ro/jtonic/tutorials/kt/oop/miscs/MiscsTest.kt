package ro.jtonic.tutorials.kt.oop.miscs

import io.kotlintest.matchers.shouldBe
import org.junit.Test

class MiscsTest {

  @Test
  fun `let also`() {

    var a: String? = null
    a?.let { println("This is not null") }

    a = "Antonel"
    a?.let {println("This is not null. $it")}
  }

  @Test
  fun `nullable tests`() {
    val a1: String? = null
    val a2 = a1 ?: ""

    a2 shouldBe  ""

    val a3 = a1?.let { println("a1 is not null"); a1.reversed() }
    a3 shouldBe null

    val a4 = "jtonic"

    val a5 = a4?.let {
      println("a4 is not null")
      a4.reversed()
    }

    a5 shouldBe a4.reversed()
  }

}