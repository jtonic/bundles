package ro.jtonic.coursera.one

import io.kotlintest.shouldBe
import org.junit.Test

/**
 * Created by Antonel Ernest Pazargic on 29/10/2018.
 * @author Antonel Ernest Pazargic
 */
class Week2Test {

    @Test
    fun `string extensions should work`() {
        "antonel".lastChar() shouldBe 'l'
    }

    fun isValidIdentifier(s: String): Boolean {
        val str = s.trim()
        return when {
            str.isEmpty() -> false
            str[0] in '0'..'9' -> false
            str.any { it != '_' && it !in 'a'..'z' && it !in 'A'..'Z' && it !in '0'..'9' } -> false
            else -> true
        }
    }

    @Test
    fun `should be an valid identifier`() {
        isValidIdentifier("name") shouldBe true  // true
        isValidIdentifier("_name") shouldBe true  // true
        isValidIdentifier("_12") shouldBe true    // true
        isValidIdentifier("")  shouldBe false      // false
        isValidIdentifier("012") shouldBe false   // false
        isValidIdentifier("no$")  shouldBe false   // false
    }
}
