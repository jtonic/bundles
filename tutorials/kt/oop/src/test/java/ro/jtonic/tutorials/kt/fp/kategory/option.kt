package ro.jtonic.tutorials.kt.fp.kategory

import arrow.core.Option
import arrow.core.Some
import arrow.core.ev
import arrow.core.monad
import arrow.typeclasses.binding

/**
 * Created by Antonel Ernest Pazargic on 10/12/2017.
 * @author Antonel Ernest Pazargic
 */

object Nuke

object Target
object Impacted

fun arm(): Option<Nuke> = Some(Nuke)
fun aim(): Option<Target> = Some(Target)
fun launch(nuke: Nuke, target: Target): Option<Impacted> = Some(Impacted)

fun main(args: Array<String>) {
    val eval = Option.monad().binding {
        val nuke = arm().bind()
        val target = aim().bind()
        val impact = launch(nuke, target).bind()
        yields(impact)
    }.ev()

    println("launch() = $eval")
}