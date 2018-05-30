package ro.jtonic.tutorials.kt.reactive

import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.Deferred
import kotlinx.coroutines.experimental.async
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.runBlocking
import java.util.concurrent.TimeUnit
import kotlin.system.measureTimeMillis

/**
 * Created by Antonel Ernest Pazargic on 30/05/2018.
 * @author Antonel Ernest Pazargic
 */
object CoroutineMain {

    @JvmStatic
    fun main(args: Array<String>) {

        val defElapsedTime: Deferred<Long> = async(context = CommonPool) {
            runDelayed()
        }

        runBlocking {
            val elapsedTime = defElapsedTime.await()
            println("elapsedTime = $elapsedTime")
        }
    }

    suspend fun runDelayed() =
            measureTimeMillis {
                println("before delay")
                delay(2, TimeUnit.SECONDS)
                println("after delay")
            }

}
