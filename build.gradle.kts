plugins {
    application
    id("java")
    id("com.coditory.manifest") version "0.2.6"

}

tasks.jar {
    manifest {
        attributes("Main-Class" to "dk.medtrace.Main")
    }
}

group = "dk.medtrace"
version = "1.0-SNAPSHOT"
repositories {
    mavenCentral()
}

dependencies {
    compileOnly("org.projectlombok:lombok:1.18.26")
    annotationProcessor("org.projectlombok:lombok:1.18.26")

    testCompileOnly("org.projectlombok:lombok:1.18.26")
    testAnnotationProcessor("org.projectlombok:lombok:1.18.26")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.1")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.1")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}

