
plugins {
    id("io.franzbecker.gradle-lombok") version(Versions.lombokPlugicVersion)
}

dependencies {
    compileOnly("org.projectlombok:lombok:${Versions.lombokVersion}")
}
