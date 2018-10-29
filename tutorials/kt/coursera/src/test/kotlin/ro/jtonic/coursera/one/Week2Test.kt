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
}
