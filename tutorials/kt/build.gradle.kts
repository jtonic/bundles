
import org.jetbrains.kotlin.allopen.gradle.AllOpenExtension
import org.jetbrains.kotlin.gradle.dsl.Coroutines

dependencies {
    compile(Deps.rxKotlin)
    compile(Deps.rxJava)
    compile(Deps.tornadoFx)
    compile(Deps.httpClient)
    compile(Deps.materialDesign)
    compile(Deps.controlFx)
    compile(Deps.koin)

    testCompile(Deps.mockitoKotlin)
    testCompile(Deps.fuel)
    testCompile(Deps.fuelCoroutines)
    testCompile(Deps.fuelJackson)
}

kotlin {
    experimental {
        coroutines = Coroutines.ENABLE
    }
}

configure<AllOpenExtension> {
    annotations(listOf("ro.jtonic.tutorials.core.Open"))
}
