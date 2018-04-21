package ro.jtonic.tutorials.kt.kotlinexplained

import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.launch
import kotlinx.coroutines.experimental.runBlocking
import org.junit.Test
import java.util.concurrent.TimeUnit

/**
 * Created by Antonel Ernest Pazargic on 21/04/2018.
 * @author Antonel Ernest Pazargic
 */
class ConcurrentTest {

    @Test
    fun `coroutines example`() {

        runBlocking {
            launch {
                println("Kotlin!!!")
                delay(200, TimeUnit.MILLISECONDS)
            }

            print("Hello ")
            delay(500, TimeUnit.MILLISECONDS)
        }
    }
}
