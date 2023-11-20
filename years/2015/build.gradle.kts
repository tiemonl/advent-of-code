import Dependencies.Testing.simpleTesting

plugins {
    id(Plugins.libraryConventions.id)
    kotlin(Plugins.pluginKotlinJVM)
    kotlin(Plugins.pluginKotlinSerialization)
}

dependencies {
    // Kotlin
    implementation(Dependencies.KotlinX.serialization)

    // Testing
    testImplementation(platform(Dependencies.Testing.junitBom))
    simpleTesting()

    implementation(project(Modules.core))
    implementation(project(Modules.models))
    implementation(project(Modules.utils))
}
