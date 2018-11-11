package ro.jtonic.tutorials.kt.kotlinexplained

import kotlinx.coroutines.channels.produce
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.time.delay
import org.junit.Test
import java.time.Duration
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

            val channel = produce<Char> {
                repeat(10_000) {
                    delay(Duration.ofMillis(1))
                    channel.send('.')
                    delay(Duration.ofMillis(1))
                    channel.send(',')
                }
                channel.close()
            }
            for(ch in channel) {
                print(ch)
            }
        }
    }
}
