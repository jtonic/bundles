package ro.jtonic.tutorials.reactive

import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.rxkotlin.toObservable
import io.reactivex.subjects.PublishSubject
import org.junit.Test

/**
 * Created by Antonel Ernest Pazargic on 15/12/2017.
 * @author Antonel Ernest Pazargic
 */
class ReactiveTest {

    @Test
    fun `test a simple observable collection`() {
        val lst = listOf(1, 2, 3, 4, 5)
        val observable = lst.toObservable()
        observable.subscribeBy(
                onNext = { println(it) },
                onError = { it.printStackTrace() },
                onComplete = { println("Done") }
        )
    }

    @Test
    fun `test reactive even odd`() {
        val subject = PublishSubject.create<Int>()

        subject.map { it % 2 == 0 }.subscribe { println(if (it) "is eaven" else "is odd") }

        subject.onNext(3)
        subject.onNext(4)
        subject.onComplete()
    }
}