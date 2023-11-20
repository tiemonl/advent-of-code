import Dependencies.Testing.simpleTesting

plugins {
    id(Plugins.libraryConventions.id)
    kotlin(Plugins.pluginKotlinJVM)
}

dependencies {
    // Testing
    testImplementation(platform(Dependencies.Testing.junitBom))
    simpleTesting()

    api(project(Modules.core))
    implementation(project(Modules.models))
    implementation(project(Modules.utils))
}
