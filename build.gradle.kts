import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

val kotlinVersion= properties["kotlinVersion"].toString()
val kotlinTest = "2.0.7"
val junitVersion = "5.0.1"

buildscript {
//    extra["kotlinVersion"] = properties["kotlinVersion"].toString() //"1.1.51"
    extra["kotlinVersion"] = "1.1.51"
    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:${extra["kotlinVersion"]}")
    }
    repositories { jcenter() }
}

allprojects {
    group = "ro.jtonic.bundles"
    version = "0.0.1-SNAPSHOT"
    extra["spring-boot-version"] = "2.0.0.M5"
    extra["junit-gradle-version"] = "1.0.1"

    repositories {
        jcenter()
    }
}

subprojects {
    tasks.withType<KotlinCompile> {
        kotlinOptions {
            suppressWarnings = true
            languageVersion = "1.1"
            apiVersion = "1.1"
            jvmTarget = "1.8"
            javaParameters = true
            incremental = true
            freeCompilerArgs = listOf("-Xjsr305=strict")
        }
        dependencies {
            "compile"(kotlin("stdlib-jre8", kotlinVersion))
            "compile"("org.jetbrains.kotlin:kotlin-reflect:$kotlinVersion")

            "testCompile"("org.junit.jupiter:junit-jupiter-params:$junitVersion")
            "testCompile"("org.junit.jupiter:junit-jupiter-api:$junitVersion")
            "testCompile"("org.junit.jupiter:junit-jupiter-engine:$junitVersion")
            "testCompile"("io.kotlintest:kotlintest:$kotlinTest")
        }
    }
}

plugins {
    base
}

task("kotlinVersion") {
    println("Kotlin version: $kotlinVersion")
}

dependencies {
    subprojects.forEach {
        archives(it)
    }
}

task<Wrapper>("wrapper") {
    gradleVersion = "4.3-rc-4"
}
