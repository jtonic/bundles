@file:JvmName(name = "FilePrivateUtils")

package ro.jtonic.tutorials.kt.oop.miscs

private const val PI = Math.PI
const val E = Math.E

private fun computePi() = PI
fun computeE() = E

class MyMath {

    val e: Double = FilePrivateUtils@::E.get()
    val pi = FilePrivateUtils@::PI.get()

    fun computingPi() = FilePrivateUtils@::computePi.invoke()
    fun computingE() = FilePrivateUtils@::computeE.invoke()
}



