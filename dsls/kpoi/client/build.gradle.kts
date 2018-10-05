plugins {
    application
}

application {
    mainClassName = "ro.jtonic.handson.poi.TestKt"
}

dependencies {
    compile(project(":dsls:kpoi:dsl"))
}
