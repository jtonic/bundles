import Versions.junitVersion
import Versions.kotlinVersion
import Versions.restAssuredVersion

buildscript {
    dependencies {
        classpath(Deps.springBootGradlePlugin)
        classpath(Deps.kotlinAllOpen)
    }
}

plugins {
    application
    id("kotlin-spring")
    id("org.springframework.boot") version(Versions.springBoot2Version)
    id("io.spring.dependency-management") version(Versions.springDependencyManagementVersion)
}

dependencyManagement {
    imports {
        mavenBom("org.springframework.cloud:spring-cloud-dependencies:Edgware.SR2")
    }
}

application { mainClassName = "ro.jtonic.handson.springboot2.SpringBoot2App" }

dependencies {
    compile(Deps.springBoot2WebStarter)
    compile(Deps.springBoot2WebFluxStarter)

    testCompile(Deps.springBoot2TestStarter)
    testCompile(Deps.reactorTest)
    testCompile(Deps.junit)
}
