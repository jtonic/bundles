package ro.jtonic.tutorials.kt.tutorials.coroutines

import io.kotlintest.shouldBe
import org.junit.Ignore
import org.junit.Test
import java.util.concurrent.TimeUnit
import java.util.concurrent.atomic.AtomicLong
import kotlin.concurrent.thread

class CoroutineTest {

/*
    @Test
    fun `test coroutines`() {
        var count = AtomicLong(0)

        val jobs = mutableListOf<Job>()

        val start = System.currentTimeMillis()
        for (i in 1..1_000_000) {
            val job = launch {
                count.incrementAndGet()
                delay(Duration.ofMillis(1_000L))
            }
            jobs += job
        }

        val result = runBlocking {
            jobs.forEach { it.join() }
            count.get()
        }
        println("Executed in ${System.currentTimeMillis() - start} millis")
        result shouldBe 1_000_000L
    }
*/

    @Test
    @Ignore("This fails with OOME")
    fun `test with threads`() {
        val count = AtomicLong(0)
        val threads = mutableListOf<Thread>()

        val start = System.currentTimeMillis()
        for (i in 1..1_000_000) {
            threads += thread {
                count.incrementAndGet()
                TimeUnit.SECONDS.sleep(1)
            }
        }

        threads.forEach(Thread::join)
        println("Executed in ${System.currentTimeMillis() - start} millis")
        count.get() shouldBe 1_000_000L
    }
}
