
buildscript {
    repositories {
        maven {
            url = uri("https://plugins.gradle.org/m2/")
        }
        maven {
            url = uri("https://dl.bintray.com/kotlin/kotlin-dev/")
        }
        maven {
            url = uri("https://oss.sonatype.org/content/repositories/snapshots/")
        }
        maven {
            url = uri("http://dl.bintray.com/jetbrains/intellij-plugin-service")
        }
    }

    dependencies {
        classpath(Deps.springBootGradlePlugin)
        classpath(Deps.kotlinAllOpen)
        classpath(Deps.kotlinNoArg)
    }
}

plugins {
    application
    id("kotlin-spring")
    id("org.springframework.boot") version(Versions.springBoot1Version)
    id("io.spring.dependency-management") version(Versions.springDependencyManagementVersion)
    id("org.jetbrains.kotlin.plugin.noarg")
    id("org.jetbrains.kotlin.plugin.allopen")
}

dependencyManagement {
    imports {
        mavenBom("org.springframework.cloud:spring-cloud-dependencies:Edgware.SR2")
    }
}

application {
    mainClassName = "ro.jtonic.handson.springbapp.clientserver.ServerApp"
}

dependencies {
    compile(Deps.springBoot1Starter)
    compile(Deps.springBoot1WebStarter)
    compile(Deps.springBoot1AopStarter)
    compile(Deps.springCloudFeignStarter)
    compile(Deps.springCloudRibbonStarter)
    compile(Deps.jacksonModuleKotlin)
    compile(Deps.jacksonDatabind)
    compile(Deps.aopAliance)

    testCompile(Deps.springBoot1TestStarter)
    testCompile(Deps.junit)
    testCompile(Deps.restAssured)
    testCompile(Deps.restAssuredSchemaValidation)
}

allOpen {
    annotation("ro.jtonic.handson.springbapp.clientserver.annotation.Open")
}

noArg {
    annotation("ro.jtonic.handson.springbapp.clientserver.annotation.NoArgs")
}
