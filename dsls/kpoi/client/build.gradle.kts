plugins {
    application
}

apply {
    plugin("kotlin")
}

application {
    mainClassName = "ro.jtonic.handson.poi.TestKt"
}

dependencies {
    compile(project(":dsls:kpoi:dsl"))
}
