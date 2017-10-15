import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

val kotlinVersion = "1.1.51"

buildscript {
    dependencies { classpath(kotlin("gradle-plugin")) }
    repositories { jcenter() }
}

allprojects {
    group = "ro.jtonic.bundles"
    version = "0.0.1-SNAPSHOT"
    extra["kotlin-ver"] = kotlinVersion

    repositories {
        jcenter()
    }
}

subprojects {
    tasks.withType<KotlinCompile> {
        kotlinOptions {
            suppressWarnings = true
        }
        dependencies {
            "compile"(kotlin("stdlib-jre8", kotlinVersion))
            "testCompile"("junit:junit:4.12")
            "testCompile"("io.kotlintest:kotlintest:2.0.7")
        }
    }
}

plugins {
    base
}

dependencies {
    subprojects.forEach {
        archives(it)
    }
}