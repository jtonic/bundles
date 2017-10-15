package ro.jtonic.tutorials.kt.oop.delegate

import ro.jtonic.tutorials.kt.oop.delegate.imp.wired

class Person(private val fName: String, private val lName: String) {
    val name: String
        get() {
            return "$fName $lName"
        }
    var age: Int by wired
}