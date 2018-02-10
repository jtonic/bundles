package ro.jtonic.tutorials.kt.tutorials

import org.junit.Test
import kotlin.properties.Delegates

/**
 * Created by Antonel Ernest Pazargic on 10/02/2018.
 * @author Antonel Ernest Pazargic
 */
class DelegatesTest {

    @Test
    fun `simple delegate`() {
        var a: String by Delegates.observable("", onChange = {_, oldValue, newValue-> println("$oldValue -> $newValue")})
        a = "a"
        a = "b"
    }
}