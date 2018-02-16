package ro.jtonic.tutorials.kt.tutorials

import org.junit.Test

/**
 * Created by Antonel Ernest Pazargic on 14/02/2018.
 * @author Antonel Ernest Pazargic
 */
class SimpleExampleWithSampleTest {

    @Test
    fun testFoo1(): String {
        val input = "This is it!!!"
        return SimpleExampleWithSample().foo(input)
    }

    @Test
    fun `test foo 2`() {
        SimpleExampleWithSample().foo("This is it!!!")
    }
}