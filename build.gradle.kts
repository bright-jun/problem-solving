plugins {
    kotlin("jvm") version "2.0.0"
    id("org.jlleitschuh.gradle.ktlint") version "11.6.1"
}

group = "problem.solving"
version = "1.0-SNAPSHOT"

sourceSets {
    main {
        java {
            setSrcDirs(listOf("src/main"))
        }
        kotlin {
            setSrcDirs(listOf("src/main"))
        }
        resources {
            setSrcDirs(listOf("src/main/resources"))
        }
    }
    test {
        java {
            setSrcDirs(listOf("src/test"))
        }
        kotlin {
            setSrcDirs(listOf("src/test"))
        }
        resources {
            setSrcDirs(listOf("src/test/resources"))
        }
    }
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    testImplementation("io.kotest:kotest-runner-junit5-jvm:5.9.1")
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(21)
}
