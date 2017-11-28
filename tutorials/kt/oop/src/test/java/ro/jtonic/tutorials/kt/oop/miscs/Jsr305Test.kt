package ro.jtonic.tutorials.kt.oop.miscs

import io.kotlintest.matchers.gt
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
        val document = "my document"
        Printer().printPage(page)?.length ?: 0 shouldBe 0
        Printer().printDocument(document).length shouldBe gt(document.length)
    }
}