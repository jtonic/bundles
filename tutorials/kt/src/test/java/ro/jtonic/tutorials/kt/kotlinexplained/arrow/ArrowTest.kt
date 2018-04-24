package ro.jtonic.tutorials.kt.kotlinexplained.arrow

import arrow.core.Either
import arrow.core.Option
import arrow.core.constant
import arrow.core.fix
import arrow.core.identity
import arrow.core.monad
import arrow.syntax.function.pipe
import arrow.typeclasses.binding
import io.kotlintest.matchers.shouldBe
import org.junit.Test

/**
 * Created by Antonel Ernest Pazargic on 06/04/2018.
 * @author Antonel Ernest Pazargic
 */
class ArrowTest {

    @Test
    fun `identity and constant functions`() {

        listOf(1, 2, 3).map(::identity) shouldBe listOf(1, 2, 3)
        listOf("a", "b", "c").map(constant(1)) shouldBe listOf(1, 1, 1)
    }

    @Test
    fun `monads comprehension - composition of pure and inpure functions`() {

        fun imdbFinder(artistName: String): Either<String, arrow.core.Option<List<String>>> {
            // imdb db search
            return when (artistName) {
                "Brad Pitt" -> Either.right(arrow.core.Option.just(listOf("Troy", "The inglorious bastards")))
                "Angelina Jolie" -> Either.right(arrow.core.Option.just(listOf("Lara Croft", "Original Sin", "Changeling")))
                "Antonel Ernest Pazargic" -> Either.right(Option.empty())
                else -> Either.left("Error accessing db...")
            }
        }


        val antonelErnestPazargicMovies = imdbFinder("Antonel Ernest Pazargic")
        val magdaPalimariuMovies = imdbFinder("Magda")

        // *****************************************
        // monads comprehension.
        // a little bit better
        // *****************************************
        val familyMovies = Either.monad<String>().binding {
            val angelinaJolieMovies = imdbFinder("Angelina Jolie").bind()
            val bradPittMovies = imdbFinder("Brad Pitt")
            angelinaJolieMovies.map { ajm -> bradPittMovies.map { bpm -> ajm + bpm } }
        }.fix()

        familyMovies.fold(::identity, { op1 ->
            op1.fold({ "Not found" }, { op2 ->
                op2.fold({ "Not found" }, { op3 -> op3.toString()})
            })
        }) pipe ::println
    }
}
