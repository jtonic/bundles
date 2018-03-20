package ro.jtonic.tutorials.kt.oop

import io.kotlintest.matchers.shouldBe
import org.junit.Test
import kotlin.reflect.full.findAnnotation

/**
 * Created by Antonel Ernest Pazargic on 20/03/2018.
 * @author Antonel Ernest Pazargic
 */
class AnnotationTest {


    @Target(AnnotationTarget.CLASS)
    @Retention(AnnotationRetention.RUNTIME)
    annotation class Smell(val good: Boolean = true)

    @Test
    fun `simple annotation test`() {

        @Smell
        class Pancake(val flavour: Flavour)

        val almondPancake = Pancake("strawberry")
        val goodSmell = almondPancake::class.findAnnotation<Smell>()?.good?.toString() ?: "false"
        goodSmell shouldBe "true"
    }

}
