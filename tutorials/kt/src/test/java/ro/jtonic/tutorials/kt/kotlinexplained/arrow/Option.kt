package ro.jtonic.tutorials.kt.kotlinexplained.arrow

/**
 * Created by Antonel Ernest Pazargic on 22/04/2018.
 * @author Antonel Ernest Pazargic
 */
sealed class Option<out T> {

    object None : Option<Nothing>()

    class Some<out T>(val value: T) : Option<T>()

    companion object
}

fun <T, R> Option<T>.map(tr: (T) -> R): Option<R> =
        flatMap { Option.Some(tr(it)) }

fun <T, R> Option<T>.flatMap(tr: (T) -> Option<R>): Option<R> =
        when (this) {
            is Option.None -> Option.None
            is Option.Some -> tr(value)
        }

fun <T> Option.Companion.pure(t: T) = Option.Some(t)

fun <T, R> Option<T>.ap(fab: Option<(T) -> R>): Option<R> = fab.flatMap { f -> this.map(f) }
