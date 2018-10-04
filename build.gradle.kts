import org.jetbrains.kotlin.config.AnalysisFlag.Flags.experimental
import org.jetbrains.kotlin.contracts.model.structure.UNKNOWN_COMPUTATION.type
import org.jetbrains.kotlin.gradle.dsl.Coroutines
import org.jetbrains.kotlin.gradle.dsl.KotlinJvmProjectExtension
import org.jetbrains.kotlin.gradle.dsl.KotlinProjectExtension
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

group = "ro.jtonic.bundles"
version = Versions.projectVersion

buildscript {
    repositories {
        mavenCentral()
        jcenter()
        maven {
            url = uri("https://plugins.gradle.org/m2/")
        }
    }

    dependencies {
        classpath(Plugins.kotlinGradle)
        classpath(Plugins.kotlinNoArg)
        classpath(Plugins.kotlinAllOpen)
    }
}

plugins {
    maven
    java
    id("io.gitlab.arturbosch.detekt").version(Versions.detektVersion)
}

allprojects {

    repositories {
        mavenCentral()
        jcenter()
        maven{
            url = uri("http://dl.bintray.com/kategory/maven")
        }
    }

    apply {
        plugin("java")
        plugin("kotlin")
        plugin("kotlin-allopen")
        plugin("kotlin-noarg")
    }

    dependencies {
        compile(Deps.kotlinStdLib) {
            isForce = true
        }
        compile(Deps.kotlinReflect) {
            isForce = true
        }
        compile (Deps.jsr305)
        compile (Deps.kotlinCoroutines)

        compile (Deps.arrowFree)
        compile (Deps.arrowCore)
        compile (Deps.arrowData)
        compile (Deps.arrowInstancesData)
        compile (Deps.arrowSyntax)

        compile (Deps.kotlinTestAssertions)
        testCompile (Deps.junit)
        testCompile (Deps.mockitoKotlin)
    }

    configure<JavaPluginConvention> {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    tasks.withType<JavaCompile> {
        options.encoding = "UTF-8"
    }

    configure<KotlinProjectExtension> {
        experimental.coroutines = Coroutines.ENABLE
    }

    tasks.withType<KotlinCompile> {
        kotlinOptions {
            suppressWarnings = true
            languageVersion = Versions.kotlinLanguageVersion
            apiVersion = Versions.kotlinApiVersion
            jvmTarget = Versions.kotlinJvmTarget
            javaParameters = true
            incremental = true
            freeCompilerArgs = listOf("-Xdisable-default-scripting-plugin", "-Xjsr305=strict", "-Xjvm-default=enable")
        }
    }

    dependencies {
        compile("org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Versions.kotlinVersion}") {
            isForce = true
        }
        compile("org.jetbrains.kotlin:kotlin-reflect:${Versions.kotlinVersion}") {
            isForce = true
        }
        compile ("com.google.code.findbugs:jsr305:${Versions.findBugsVersion}")
        compile ("org.jetbrains.kotlinx:kotlinx-coroutines-jdk8:${Versions.kotlinCoroutinesVersion}")

        compile ("io.arrow-kt:arrow-free:${Versions.arrowVersion}")
        compile ("io.arrow-kt:arrow-core:${Versions.arrowVersion}")
        compile ("io.arrow-kt:arrow-data:${Versions.arrowVersion}")
        compile ("io.arrow-kt:arrow-instances-data:${Versions.arrowVersion}")
        compile ("io.arrow-kt:arrow-syntax:${Versions.arrowVersion}")

        compile ("io.kotlintest:kotlintest-assertions:${Versions.kotlinTestVersion}")
        testCompile ("junit:junit:${Versions.junitVersion}")
        testCompile ("com.nhaarman.mockitokotlin2:mockito-kotlin:${Versions.mockitoKotlinVersion}")
    }
}

detekt {
    version = Versions.detektVersion

    profile("main") {
        input = "$projectDir/src/main/java"
        config = "$rootDir/detekt.yml"
        disableDefaultRuleSets = false
        output = "$buildDir/reports/detekt"
        outputName = "bundles"
        // baseline = "$project.projectDir/reports/baseline.xml" // If present all current findings are saved in a baseline.xml to only consider new code smells for further runs.
        parallel = true // Use this flag if your project has more than 200 files.
    }
}

configurations.all {
    resolutionStrategy {
        force("org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlinVersion}")
        force("org.jetbrains.kotlin:kotlin-reflect:${Versions.kotlinVersion}")
    }
}

tasks.withType<Wrapper> {
    gradleVersion = Versions.gradleVersion
    distributionType = Wrapper.DistributionType.ALL
    //    distributionUrl = "gradle-$gradleVersion-all.zip"
    distributionUrl = "http://services.gradle.org/distributions/gradle-${Versions.gradleVersion}-all.zip"
}
