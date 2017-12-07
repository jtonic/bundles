package ro.jtonic.tutorials.kt.oop.miscs

import io.kotlintest.matchers.plusOrMinus
import io.kotlintest.matchers.shouldBe
import org.junit.Test
import kotlin.math.PI

/**
 * Created by Antonel Ernest Pazargic on 07/12/2017.
 * @author Antonel Ernest Pazargic
 */
class FilePrivateTest {

    @Test
    fun `test file private things`() {
        E shouldBe (Math.E plusOrMinus 0.02)
        // The following doesn't compile. It is file private constant
        // PI shouldBe Math.PI

        computeE() shouldBe (E plusOrMinus 0.02)
        // The following doesn't compile. It is file private constant
        // computePI shouldBe Math.PI

        MyMath().e shouldBe (E plusOrMinus 0.02)
        MyMath().pi shouldBe (PI plusOrMinus 0.02)

        MyMath().computingE() shouldBe (E plusOrMinus 0.02)
        MyMath().computingPi() shouldBe (PI plusOrMinus 0.02)
    }
}