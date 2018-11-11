package ro.jtonic.tutorials.kt.kotlinexplained.arrow

import arrow.core.constant
import arrow.core.identity
import io.kotlintest.shouldBe
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

/*
    @Test
    fun `monads transformer - composition of pure and inpure functions`() {

        fun getMovies(artistName: String): Either<String, Option<List<String>>> {
            return when (artistName) {
                "Brad Pitt" -> Either.right(Option.just(listOf("Troy", "The inglorious bastards")))
                "Angelina Jolie" -> Either.right(Option.just(listOf("Lara Croft", "Original Sin", "Changeling")))
                "Antonel Ernest Pazargic" -> Either.right(Option.empty())
                else -> Either.left("Error accessing db...")
            }
        }

        val bradPittMovies: Either<String, Option<List<String>>> = getMovies("Brad Pitt")
        val angelinaJolieMovies: Either<String, Option<List<String>>> = getMovies("Angelina Jolie")

        val moviesM: Either<String, Option<List<String>>> = OptionT.monad(Either.monad<String>()).binding {
            val bradPittMovies: List<String> = OptionT(bradPittMovies).bind()
            val angelinaJolieMovies: List<String> = OptionT(angelinaJolieMovies).bind()
            val familyMovies: List<String> = bradPittMovies + angelinaJolieMovies
            familyMovies
        }.value().fix()

        val movies: String = moviesM.fold(::identity, { op -> op.fold({ "not found" }, { it.joinToString() }) })
        movies pipe ::println
    }
*/
}



















