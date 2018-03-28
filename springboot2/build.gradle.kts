//apply plugin: 'application'

plugins {
    id("kotlin-spring")
    id("org.springframework.boot") version "2.0.0.RELEASE"
    id("io.spring.dependency-management") version "1.0.4.RELEASE"
}

buildscript {
    dependencies {
        classpath("org.springframework.boot:spring-boot-gradle-plugin:${project.property("springBootVersion")}")
        classpath("org.jetbrains.kotlin:kotlin-allopen:${project.property("kotlinVersion")}")
    }
}

/*
dependencyManagement {
    imports {
        mavenBom 'org.springframework.cloud:spring-cloud-dependencies:Edgware.SR2'
    }
}
*/

//mainClassName = "ro.jtonic.handson.springbapp.Application"

dependencies {
    compile("org.springframework.boot:spring-boot-starter")
    compile("org.springframework.boot:spring-boot-starter-web")
    //    compile 'org.springframework.cloud:spring-cloud-starter-feign'
    //    compile 'org.springframework.cloud:spring-cloud-starter-ribbon'

    //    compile "io.rest-assured:json-schema-validator:$restAssuredVersion"


    testCompile("org.springframework.boot:spring-boot-starter-test")
    testCompile("junit:junit:${project.property("junitVersion")}")
    testCompile("io.rest-assured:rest-assured:${project.property("restAssuredVersion")}")
    // "expectedBy"(project(":common"))  // what this stands for ????
}
