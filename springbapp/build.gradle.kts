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

apply {
    plugin("org.springframework.boot")
    plugin("kotlin-spring")
    plugin("kotlin")
    plugin("io.spring.dependency-management")
}

repositories {
    mavenCentral()
}

dependencies {
    "compile"("org.springframework.boot:spring-boot-starter:1.5.8.RELEASE")
    // "expectedBy"(project(":common"))  // what this stands for
}
