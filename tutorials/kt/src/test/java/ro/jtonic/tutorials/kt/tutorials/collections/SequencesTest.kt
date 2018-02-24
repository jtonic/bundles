package ro.jtonic.tutorials.kt.tutorials.collections

import org.junit.Test

/**
 * Created by Antonel Ernest Pazargic on 24/02/2018.
 * @author Antonel Ernest Pazargic
 */
class SequencesTest {

    @Test
    fun `java for translated to kotlin`() {

        val names =  listOf(1, 3, 5, 7, 0, 2, 13)

        val result = generateSequence(names.size - 1) { it / 2 }.takeWhile { it > 0 }
        result.forEach { println(it) }
    }
}