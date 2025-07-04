import org.springframework.boot.gradle.tasks.run.BootRun

plugins {
    java
    id("org.springframework.boot") version "3.5.0"
    id("io.spring.dependency-management") version "1.1.7"
}

group = "dev.shiftsad"
version = "0.0.1-SNAPSHOT"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-actuator")
    implementation("org.springframework.boot:spring-boot-starter-cache")
    implementation("net.sourceforge.tess4j:tess4j:5.16.0")
    implementation("org.apache.pdfbox:pdfbox:3.0.5")
    implementation("com.github.ben-manes.caffeine:caffeine:3.2.1")
    compileOnly("org.projectlombok:lombok")
    developmentOnly("org.springframework.boot:spring-boot-devtools")
    runtimeOnly("org.postgresql:postgresql")
    annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")
    annotationProcessor("org.projectlombok:lombok")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    runtimeOnly("io.micrometer:micrometer-registry-prometheus")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

configurations.all {
    exclude(group = "commons-logging", module = "commons-logging")
}

tasks.register<BootRun>("importIbge") {
    group = "import"
    description = "Import IBGE data into the database"
    mainClass.set("dev.shiftsad.capag.CapagApplication")
    classpath = sourceSets.main.get().runtimeClasspath
    args("--import", "ibge")
}

tasks.register<BootRun>("importCapag") {
    group = "import"
    description = "Import Capag data into the database"
    mainClass.set("dev.shiftsad.capag.CapagApplication")
    classpath = sourceSets.main.get().runtimeClasspath
    args("--import", "capag")
}