package ro.jtonic.tutorials.kt.fp.kategory

import arrow.core.ForOption
import arrow.core.Option
import arrow.core.Some
import arrow.core.fix
import arrow.instances.extensions
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

    val eval = ForOption extensions {
        binding {
            val nuke = arm().bind()
            val target = aim().bind()
            val impact = launch(nuke, target).bind()
            impact
        }.fix()
    }
    println("launch() = $eval")
}
