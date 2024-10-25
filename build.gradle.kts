plugins {
    kotlin("jvm") version "1.9.0"
    application
    id("io.realm.kotlin") version "1.10.0"
}

group = "com.dev0ko.rijalback"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    implementation("io.realm.kotlin:library-base:1.10.0")
    implementation("com.google.code.gson:gson:2.10.1")
    implementation("com.squareup.okhttp:okhttp:2.7.5")

}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(8)
}

application {
    mainClass.set("MainKt")
}