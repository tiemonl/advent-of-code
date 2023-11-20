rootProject.name = "advent-of-code"

plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.7.0"
}

// Modules
include(":modules:core")
include(":modules:models")
include(":modules:utils")

// Years
include(":years:2015")
include(":years:2021")
include(":years:2022")
