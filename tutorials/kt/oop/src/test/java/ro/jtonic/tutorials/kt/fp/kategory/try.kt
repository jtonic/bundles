package ro.jtonic.tutorials.kt.fp.kategory

import kategory.Try
import kategory.binding
import kategory.ev
import kategory.monad

class ArmException(msg: String) : RuntimeException(msg)

class AimException(msg: String) : RuntimeException(msg)

class TryExample {

    /**
     * Created by Antonel Ernest Pazargic on 10/12/2017.
     * @author Antonel Ernest Pazargic
     */


    companion object {

        fun arm(): Try<Nuke> = Try { throw AimException("Could't arm...") }
        fun aim(): Try<Target> = Try { throw ArmException("Could't aim...") }
        fun lauch(nuke: Nuke, target: Target): Try<Impacted> = Try { throw IllegalArgumentException("Couldn't launch") }
    }

}

fun main(args: Array<String>) {
    TryExample.arm().fold({ println(it.message) }, { println("successfully armed $it") })
    TryExample.aim().fold({ println(it.message) }, { println("successfully aimed $it") })

    val ev: Try<Impacted> = Try.monad().binding {
        val nuke = TryExample.arm().bind()
        val target = TryExample.aim().bind()
        val impact = TryExample.lauch(nuke, target).bind()
        yields(impact)
    }.ev()
    ev.fold({ println("Exception: ${it.message}") }, {println("Got the impact: $it")})
}
