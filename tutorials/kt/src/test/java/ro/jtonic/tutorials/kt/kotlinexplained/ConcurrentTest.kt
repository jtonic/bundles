package ro.jtonic.tutorials.kt.kotlinexplained

import org.junit.Test
import java.util.concurrent.TimeUnit
import kotlin.concurrent.thread

/**
 * Created by Antonel Ernest Pazargic on 21/04/2018.
 * @author Antonel Ernest Pazargic
 */
class ConcurrentTest {

    @Test
    fun `simple kt thread example`() {
        thread {
            TimeUnit.MILLISECONDS.sleep(200)
            println("Kotlin!")
        }
        print("Hello ")
        TimeUnit.MILLISECONDS.sleep(500)
    }
}
