package ro.jtonic.handson.springbapp.model.hr

/**
 * Created by Antonel Ernest Pazargic on 23/03/2018.
 * @author Antonel Ernest Pazargic
 */
data class Employee(var id: Int, var name: String) {

    override fun toString(): String {
        return "$id: $name"
    }
}
