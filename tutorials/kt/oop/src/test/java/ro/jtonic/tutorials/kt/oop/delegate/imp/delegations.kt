package ro.jtonic.tutorials.kt.oop.delegate.imp

import ro.jtonic.tutorials.kt.oop.delegate.Person
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

val wired: AgeDelegate
    get() = AgeDelegate(48)

class AgeDelegate(private var propValue: Int) : ReadWriteProperty<Person, Int> {

    override fun getValue(thisRef: Person, property: KProperty<*>): Int {
        return propValue
    }

    override fun setValue(thisRef: Person, property: KProperty<*>, value: Int) {
        println("$value has been assigned to '${property.name} in $thisRef.'")
        propValue = value
    }
}


