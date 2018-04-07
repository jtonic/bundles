package ro.jtonic.tutorials.kt.kotlinexplained.arrow

import arrow.syntax.function.curried
import arrow.syntax.function.reverse
import arrow.syntax.function.uncurried
import io.kotlintest.matchers.shouldBe
import org.junit.Test

/**
 * Created by Antonel Ernest Pazargic on 06/04/2018.
 * @author Antonel Ernest Pazargic
 */

class ArrowTest {

    fun div(id: String, body: String, style: String) = "<div id='$id' style='$style'>$body</div>"

    @Test
    fun `test currying`() {
        div("1", "Tony", "color:green") shouldBe "<div id='1' style='color:green'>Tony</div>"

        val divCurried = ::div.reverse().curried()
        val greenDiv1 = divCurried("color:green")
        val greenDiv2 = greenDiv1.uncurried().reverse().curried()

        greenDiv2("1")("Tony") shouldBe "<div id='1' style='color:green'>Tony</div>"
    }
}
