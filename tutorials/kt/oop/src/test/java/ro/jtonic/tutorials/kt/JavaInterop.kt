package ro.jtonic.tutorials.kt

/**
 * Created by Antonel Ernest Pazargic on 05/02/2018.
 * @author Antonel Ernest Pazargic
 */
class JavaInterop {

    @JvmOverloads
    fun print(msg: String, colored: Boolean = false): String =
            if (colored) {
                "[color] $msg"
            } else {
                "[gray] $msg"
            }
}