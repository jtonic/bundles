import Versions.controlsfxVersion
import Versions.fuelVersion
import Versions.httpClient
import Versions.koinVersion
import Versions.materialDesignFontVersion
import Versions.mockitoKotlinVersion
import Versions.rxKotlinVersion
import Versions.tornadoFxVersion
import org.jetbrains.kotlin.gradle.dsl.Coroutines

dependencies {
    compile("io.reactivex.rxjava2:rxkotlin:$rxKotlinVersion")
    compile("no.tornado:tornadofx:$tornadoFxVersion")
    compile("org.apache.httpcomponents:httpclient:$httpClient")
    compile("de.jensd:fontawesomefx-materialdesignfont:$materialDesignFontVersion")
    compile("org.controlsfx:controlsfx:$controlsfxVersion")
    compile("org.koin:koin-core:$koinVersion")

    testCompile("com.nhaarman.mockitokotlin2:mockito-kotlin:$mockitoKotlinVersion")
    testCompile("com.github.kittinunf.fuel:fuel:$fuelVersion")
    testCompile("com.github.kittinunf.fuel:fuel-coroutines:$fuelVersion")
    testCompile("com.github.kittinunf.fuel:fuel-jackson:$fuelVersion")
}

kotlin {
    experimental {
        coroutines = Coroutines.ENABLE
    }
}
