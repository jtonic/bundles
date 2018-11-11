
dependencies {
    compile(Deps.rxKotlin)
    compile(Deps.kotlinStdLib)
    compile(Deps.kotlinCoroutines)
    testCompile(project(":tutorials:kt:model"))
}
