import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.6.10"
    application
    id("org.openjfx.javafxplugin") version "0.0.8"
}

group = "com.github.mihowjingle.cartographer"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

val kotestVersion = "5.1.0"

dependencies {
    implementation(kotlin("stdlib"))
    testImplementation("io.kotest:kotest-runner-junit5:$kotestVersion")
    testImplementation("io.kotest:kotest-assertions-core:$kotestVersion")
    testImplementation("io.kotest:kotest-property:$kotestVersion")
    implementation("no.tornado:tornadofx:1.7.20")
}

tasks.test {
    useJUnitPlatform()
}

javafx {
    version = "11.0.2"
    modules = listOf("javafx.controls", "javafx.graphics", "javafx.fxml")
}

application {
    mainClass.set("todo") // todo is it even needed?
}

tasks.jar {
    manifest {
        attributes("Main-Class" to "todo")
    }
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "11"
}