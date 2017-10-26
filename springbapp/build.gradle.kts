import org.gradle.kotlin.dsl.apply
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.repositories

buildscript {

    repositories {
        mavenCentral()
    }

    dependencies {
        classpath("org.springframework.boot:spring-boot-gradle-plugin:1.5.8.RELEASE")
        classpath("org.jetbrains.kotlin:kotlin-allopen:1.1.51")
        classpath("io.spring.gradle:dependency-management-plugin:1.0.3.RELEASE")
    }
}

plugins {
    application
}

apply {
    plugin("org.springframework.boot")
    plugin("kotlin-spring")
    plugin("kotlin")
    plugin("io.spring.dependency-management")
}

application {
    mainClassName = "ro.jtonic.handson.springbapp.Application"
}

repositories {
    mavenCentral()
}

dependencies {
    compile("org.springframework.boot:spring-boot-starter")
    compile("org.springframework.boot:spring-boot-starter-web")
    testCompile("org.springframework.boot:spring-boot-starter-test")
    testCompile("junit:junit:4.12")
    // "expectedBy"(project(":common"))  // what this stands for
}
