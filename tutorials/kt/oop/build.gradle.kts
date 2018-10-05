plugins {
    application
}

application {
    mainClassName = "ro.jtonic.tutorials.kt.oop.SimpleTest"
}

dependencies {
    testCompile(project(":tutorials:kt:model"))
}
