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
    fun `threads example`() {
        TimeUnit.SECONDS.sleep(10)
        val threads = List(3_000) {
            thread {
                TimeUnit.SECONDS.sleep(1)
                print(".")
            }
        }
        threads.forEach(Thread::join)

        TimeUnit.HOURS.sleep(1)
    }
}
