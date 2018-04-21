package ro.jtonic.tutorials.kt.kotlinexplained

import kotlinx.coroutines.experimental.channels.Channel
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

            val channel = Channel<Char>()

            val job = launch {
                repeat(10_000) {
                    delay(1, TimeUnit.MILLISECONDS)
                    channel.send('.')
                    delay(1, TimeUnit.MILLISECONDS)
                    channel.send(',')
                }
                channel.close()
            }
            for(ch in channel) {
                print(ch)
            }
            job.join()
        }
    }
}
