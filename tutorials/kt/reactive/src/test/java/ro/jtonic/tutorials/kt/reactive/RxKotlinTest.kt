package ro.jtonic.tutorials.kt.reactive

import io.kotlintest.shouldBe
import io.reactivex.Maybe
import io.reactivex.Observable
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.rxkotlin.toObservable
import io.reactivex.subjects.PublishSubject
import org.junit.Test

/**
 * Created by Antonel Ernest Pazargic on 21/05/2018.
 * @author Antonel Ernest Pazargic
 */
class RxKotlinTest {

    @Test
    fun `the most simple rxKotlin example`() {

        val observable: Observable<Int> = listOf(1, 2, 3, 4, 5).toObservable()
        observable.subscribeBy(onNext = ::println)
    }


    @Test
    fun `PublishSubject factory`() {
        val subject = PublishSubject.create<String>()!!
        subject.subscribe(::println)

        subject.onNext("One")
        subject.onNext("Two")
        subject.onNext("Three")
    }

    @Test
    fun `maybe example`() {
        val m1: Maybe<Int> = Maybe.just(4)
        m1.subscribeBy(
                onSuccess = { println("on success. value = $it") },
                onError = { println("error. error = ${it.message}") },
                onComplete = { println("on complete") }
        )
        val m2: Maybe<Int> = Maybe.empty()
        m2.subscribeBy(
                onSuccess = { println("on success. value = $it") },
                onError = { println("error. error = ${it.message}") },
                onComplete = { println("on complete") }
        )
    }

    @Test
    fun `fibonacci series`() {

        val fibonacciSeq: Sequence<Int> = sequence {
            var a = 0
            var b = 1
            yield(a)
            yield(b)
            while (true) {
                val c = a + b
                yield(c)
                a = b
                b = c
            }
        }

        val fib1 = fibonacciSeq.take(3).toList()
        fib1 shouldBe listOf(0, 1, 1)

        val fib2 = fibonacciSeq.take(10).toList().joinToString()
        println("fib2 = $fib2")
    }
}
