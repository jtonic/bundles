package ro.jtonic.tutorials.kt.reactive

import kotlinx.coroutines.*
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.time.delay
import java.time.Duration
import kotlin.system.measureTimeMillis

/**
 * Created by Antonel Ernest Pazargic on 30/05/2018.
 * @author Antonel Ernest Pazargic
 */
object CoroutineMain {

    @JvmStatic
    fun main(args: Array<String>) = runBlocking {

        val defElapsedTime: Deferred<Long> = async {
            runDelayed()
        }
        val elapsedTime = defElapsedTime.await()
        println("elapsedTime = $elapsedTime")
    }

    private suspend fun runDelayed() =
            measureTimeMillis {
                println("before delay")
                delay(Duration.ofSeconds(2))
                println("after delay")
            }
}
