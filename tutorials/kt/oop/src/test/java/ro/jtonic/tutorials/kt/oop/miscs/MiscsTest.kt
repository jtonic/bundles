package ro.jtonic.tutorials.kt.oop.miscs

import org.junit.Test

class MiscsTest {

  @Test
  fun `let also`() {

    var a: String? = null
    a?.let { println("This is not null") }

    a = "Antonel"
    a?.let {println("This is not null. $it")}
  }
}