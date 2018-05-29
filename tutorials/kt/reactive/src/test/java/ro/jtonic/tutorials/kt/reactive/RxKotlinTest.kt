package ro.jtonic.tutorials.kt.reactive

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
}