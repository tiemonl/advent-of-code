plugins {
    id(Plugins.libraryConventions.id)
    kotlin(Plugins.pluginKotlinJVM)
}

dependencies {
    api(project(Modules.core))
}
