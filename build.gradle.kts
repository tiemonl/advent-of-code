import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

apply {
    from("$rootDir/tools/gradle_tests_report.gradle.kts")
}

plugins {
    kotlin("jvm") version "1.6.10"
    kotlin("plugin.serialization") version "1.5.31"
    application
}

group = "dev.garlicbread"
version = "1.0"
java.sourceCompatibility = JavaVersion.VERSION_11

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("com.google.truth:truth:1.1.3")
    implementation("org.junit.jupiter:junit-jupiter:5.7.0")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.3.1")
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "11"
}
