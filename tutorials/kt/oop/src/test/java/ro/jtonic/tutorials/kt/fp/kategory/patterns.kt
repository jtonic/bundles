package ro.jtonic.tutorials.kt.fp.kategory

/**
 * Created by Antonel Ernest Pazargic on 10/12/2017.
 * @author Antonel Ernest Pazargic
 */

object Nuke
object Target
object Impacted

fun arm(): Nuke = TODO()
fun aim(): Target = TODO()
fun launch(nuke: Nuke, target: Target): Impacted = TODO()

fun main(args: Array<String>) {
    launch(arm(), aim())
}