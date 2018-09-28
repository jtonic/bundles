package ro.jtonic.tutorials.kt.tutorials

import io.kotlintest.shouldBe
import org.junit.Test

/**
 * Created by Antonel Ernest Pazargic on 16/12/2017.
 * @author Antonel Ernest Pazargic
 */
class LazyTest {

    @Test
    fun `test by lazy`() {
        var i = 1

        val a: Int by lazy {
            println("i = $i")
            ++i
        }

        a shouldBe 2
        a shouldBe 2
    }
}
