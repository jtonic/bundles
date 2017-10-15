plugins {
    application
}

apply {
    plugin("kotlin")
    plugin("application")
}


application {
    mainClassName = "ro.jtonic.tutorials.kt.oop.SimpleTest"
}
