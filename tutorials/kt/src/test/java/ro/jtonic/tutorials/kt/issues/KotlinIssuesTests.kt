package ro.jtonic.tutorials.kt.issues

import io.kotlintest.matchers.shouldThrow
import org.junit.Test

/**
 * Created by Antonel Ernest Pazargic on 11/02/2018.
 * @author Antonel Ernest Pazargic
 */
class KotlinIssuesTests {

    @Test
    fun `go to invoke declaration doesnt work in certain cases`() {
        class Teacher {

            operator fun invoke(retired: Boolean = false) {
                println("Is teacher retired? $retired")
            }
        }

        val tony = Teacher()
        val retired = false

        tony(retired) // go to invoke declaration and show invoke definition doesn't work for this
        // for all below all is fine for declarations and definitions of tony, invoke (and retired - first line below)
        tony(retired = retired)
        tony(false)
        tony()
    }



    @Test
    fun `issue  KT-8628`() {
        shouldThrow<IllegalArgumentException> {
            println("Antonel Ernest Pazargic")
            //            throw IllegalArgumentException("Antonel Ernest")
        }
    }
}