package ro.jtonic.tutorials.kt.tutorials.fp

import io.kotlintest.matchers.haveSize
import io.kotlintest.should
import io.kotlintest.shouldNotBe
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.time.delay
import org.junit.Test
import java.time.Duration

/**
 * Created by Antonel Ernest Pazargic on 26/03/2018.
 * @author Antonel Ernest Pazargic
 */
class ImmutabilityTest {
    private var count = 0

    val field1: String = "initial_value"
        get() {
            return "$field ${++count}"
        }

    object ImmutableObject {
        var name = ""
        var age = 40
        override fun toString(): String {
            return name
        }
    }

    @Test
    fun `test the referential immutability`() {
        val iObj = ImmutableObject
        val name = iObj.name
        iObj.name = "mutated"
        name shouldNotBe iObj.name
    }

    @Test
    fun `test the referential immutability for collections`() {
        val s1 = mutableSetOf(1, 2, 3)
        //        s1+=3 the value cannot be reassigned
        s1 += 4
        s1 should haveSize(4)
    }

    @Test
    fun `test read only property with a custom getter`() {
        val f1 = this.field1
        val f2 = this.field1
        f1 shouldNotBe f2
    }

    @Test
    fun `thread unsafety`() {
        runBlocking {
            async {
                for(i in 11..20) {
                    ImmutableObject.age += i
                    println("from async1: ${ImmutableObject.age}")
                    delay(300)
                }
            }
            async {
                for(i in 1..10) {
                    ImmutableObject.age++
                    println("from async2: ${ImmutableObject.age}")
                    delay(500)
                }
            }
            delay(5_000)
        }
    }

    @Test
    fun `thread safety`() {
        runBlocking {
            async {
                var age = ImmutableObject.age
                for(i in 11..20) {
                    age += i
                    println("from async1: $age")
                    delay(300)
                }
            }
            async {
                var age = ImmutableObject.age
                for(i in 1..10) {
                    age++
                    println("from async2: $age")
                    delay(500)
                }
            }
            delay(Duration.ofSeconds(5))
        }
    }
}
