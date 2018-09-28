package ro.jtonic.tutorials.kt

import io.kotlintest.matchers.haveSize
import io.kotlintest.should
import org.junit.Test

/**
 * Created by Antonel Ernest Pazargic on 17/12/2017.
 * @author Antonel Ernest Pazargic
 */
class OperatorOverloadingTest {

    @Test
    fun `increment and get`() {
        val scopes = Scopes()
        scopes += "a"
        scopes.scopes should haveSize(1)
    }

    @Test
    fun `cool invoke overloaded`() {
        "Antonel" {
            println("likes Kotlin")
            println("likes Kotlin a lot")
            println("likes Kotlin ecosystem")
            println("likes Kotlin community a lot")
        }
    }

    operator fun String.invoke(body: String.() -> Unit) {
        this.apply(body)
    }
}

class Scopes {

    val scopes = mutableSetOf<String>()

    operator fun plusAssign(a: String) {
        scopes += a
    }
}
