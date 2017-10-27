import org.gradle.kotlin.dsl.apply
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.extra
import org.gradle.kotlin.dsl.maven
import org.gradle.kotlin.dsl.repositories


extra["junitJupiterVersion"] = "5.0.1"

buildscript {
    repositories {
        mavenLocal()
        mavenCentral()
        maven ("https://repo.spring.io/milestone")
    }

    dependencies {
        val springBootVersion = "2.0.0.M5"
        val junitGradleVersion = "1.0.0"
        classpath("org.springframework.boot:spring-boot-gradle-plugin:$springBootVersion")
        classpath("org.jetbrains.kotlin:kotlin-allopen:1.1.51")
        classpath("io.spring.gradle:dependency-management-plugin:1.0.3.RELEASE")
        classpath("org.junit.platform:junit-platform-gradle-plugin:$junitGradleVersion")
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
    mavenLocal()
    mavenCentral()
    maven ("https://repo.spring.io/milestone")
}

dependencies {
    compile("org.springframework.boot:spring-boot-starter")
    compile("org.springframework.boot:spring-boot-starter-web")
    testCompile("org.springframework.boot:spring-boot-starter-test")
}

