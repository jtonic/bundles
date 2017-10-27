import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

val kotlinVersion = "1.1.51"
val kotlinTest = "2.0.7"
val junitVersion = "5.0.1"

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

dependencies {
    subprojects.forEach {
        archives(it)
    }
}