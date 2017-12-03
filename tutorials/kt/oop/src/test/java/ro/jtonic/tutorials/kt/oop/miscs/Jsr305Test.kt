package ro.jtonic.tutorials.kt.oop.miscs

import io.kotlintest.matchers.shouldBe
import org.junit.Test
import ro.jtonic.tutorials.kt.oop.javaclasses.Printer

/**
 * Created by Antonel Ernest Pazargic on 28/11/2017.
 * @author Antonel Ernest Pazargic
 */
class Jsr305Test {

    @Test
    fun `printing a page with java Printer class`() {
        val page = null
        // the following doesn't compile
        Printer().printPage(page).length ?: 0 shouldBe 0
        Printer().printPage(page).length ?: 0 shouldBe 0

        val document = null
        Printer().printDocument(document).length ?: 0 shouldBe 0
    }
}