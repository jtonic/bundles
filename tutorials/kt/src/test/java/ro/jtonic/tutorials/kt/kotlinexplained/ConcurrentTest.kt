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
        TimeUnit.SECONDS.sleep(10)

        runBlocking {
            val jobs = List(1_000_000) {
                launch {
                    print(".")
                    delay(1, TimeUnit.SECONDS)
                }
            }
            jobs.forEach { it.join() }
        }
    }
}
