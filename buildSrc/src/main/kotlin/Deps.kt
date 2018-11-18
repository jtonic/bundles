import Versions.aopAlianceVersion
import Versions.arrowVersion
import Versions.controlsfxVersion
import Versions.fuelVersion
import Versions.httpClientVersion
import Versions.jacksonModuleKotlinVersion
import Versions.junitVersion
import Versions.koinVersion
import Versions.kotlinCoroutinesVersion
import Versions.kotlinTestVersion
import Versions.kotlinVersion
import Versions.materialDesignFontVersion
import Versions.mockitoKotlinVersion
import Versions.poiVersion
import Versions.restAssuredVersion
import Versions.rxJavaVersion
import Versions.rxKotlinVersion
import Versions.springBoot1Version
import Versions.springBoot2Version
import Versions.tornadoFxVersion

object Deps {

    val kotlinStdLib = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:$kotlinVersion"
    val kotlinReflect = "org.jetbrains.kotlin:kotlin-reflect:$kotlinVersion"
    val kotlinCoroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-jdk8:$kotlinCoroutinesVersion"
    val kotlinAllOpen = "org.jetbrains.kotlin:kotlin-allopen:$kotlinVersion"
    val kotlinNoArg = "org.jetbrains.kotlin:kotlin-noarg:$kotlinVersion"

    val jsr305 = "com.google.code.findbugs:jsr305:${Versions.findBugsVersion}"
    val arrowFree = "io.arrow-kt:arrow-free:$arrowVersion"
    val arrowCore = "io.arrow-kt:arrow-core:$arrowVersion"
    val arrowData = "io.arrow-kt:arrow-data:$arrowVersion"
    val arrowInstancesData = "io.arrow-kt:arrow-instances-data:$arrowVersion"
    val arrowSyntax = "io.arrow-kt:arrow-syntax:$arrowVersion"
    val kotlinTestAssertions = "io.kotlintest:kotlintest-assertions:$kotlinTestVersion"
    val junit = "junit:junit:$junitVersion"
    val mockitoKotlin = "com.nhaarman.mockitokotlin2:mockito-kotlin:$mockitoKotlinVersion"
    val poiDependency = "org.apache.poi:poi:$poiVersion"
    val poiOoxmlDependency = "org.apache.poi:poi-ooxml:$poiVersion"

    val rxKotlin = "io.reactivex.rxjava2:rxkotlin:$rxKotlinVersion"
    val rxJava = "io.reactivex.rxjava2:rxjava:$rxJavaVersion"
    val tornadoFx = "no.tornado:tornadofx:$tornadoFxVersion"
    val httpClient = "org.apache.httpcomponents:httpclient:$httpClientVersion"
    val materialDesign = "de.jensd:fontawesomefx-materialdesignfont:$materialDesignFontVersion"
    val controlFx = "org.controlsfx:controlsfx:$controlsfxVersion"
    val koin = "org.koin:koin-core:$koinVersion"
    val jacksonModuleKotlin = "com.fasterxml.jackson.module:jackson-module-kotlin:$jacksonModuleKotlinVersion"

    val fuel = "com.github.kittinunf.fuel:fuel:$fuelVersion"
    val fuelCoroutines = "com.github.kittinunf.fuel:fuel-coroutines:$fuelVersion"
    val fuelJackson = "com.github.kittinunf.fuel:fuel-jackson:$fuelVersion"

    val restAssured = "io.rest-assured:rest-assured:$restAssuredVersion"
    val restAssuredSchemaValidation = "io.rest-assured:json-schema-validator:$restAssuredVersion"
    val springBootGradlePlugin = "org.springframework.boot:spring-boot-gradle-plugin:$springBoot2Version"

    val springBoot2Starter = "org.springframework.boot:spring-boot-starter"
    val springBoot2WebStarter = "org.springframework.boot:spring-boot-starter-web"
    val springBoot2WebFluxStarter = "org.springframework.boot:spring-boot-starter-webflux"
    val reactorTest = "io.projectreactor:reactor-test"
    val springBoot2TestStarter = "org.springframework.boot:spring-boot-starter-test"
    val springBoot1Starter = "org.springframework.boot:spring-boot-starter:$springBoot1Version"
    val springBoot1WebStarter = "org.springframework.boot:spring-boot-starter-web:$springBoot1Version"
    val springBoot1TestStarter = "org.springframework.boot:spring-boot-starter-test:$springBoot1Version"
    val springBoot1AopStarter = "org.springframework.boot:spring-boot-starter-aop:$springBoot1Version"

    val springCloudFeignStarter = "org.springframework.cloud:spring-cloud-starter-feign"
    val springCloudRibbonStarter = "org.springframework.cloud:spring-cloud-starter-ribbon"

    val aopAliance = "aopalliance:aopalliance:$aopAlianceVersion"
}
