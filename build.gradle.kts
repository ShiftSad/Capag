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
    compileOnly("org.projectlombok:lombok")
    developmentOnly("org.springframework.boot:spring-boot-devtools")
    runtimeOnly("org.postgresql:postgresql")
    annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")
    annotationProcessor("org.projectlombok:lombok")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.withType<Test> {
    useJUnitPlatform()
}

// Python importer
val importerDir = layout.projectDirectory.dir("importer")
val venvDir = importerDir.dir("venv")
val pythonExecutable = "${venvDir.asFile.absolutePath}\\Scripts\\python.exe"
val pipExecutable = "${venvDir.asFile.absolutePath}\\Scripts\\pip.exe"

tasks.register<Exec>("setupPythonVenv") {
    description = "Sets up the Python virtual environment and installs dependencies."
    workingDir = importerDir.asFile

    doFirst {
        val importerDirFile = importerDir.asFile
        val venvDirFile = venvDir.asFile

        if (!importerDirFile.exists()) {
            println("Creating importer directory: ${importerDirFile.absolutePath}")
            importerDirFile.mkdirs()
        }

        if (venvDirFile.exists()) println("Python virtual environment already exists at ${venvDirFile.absolutePath}.")
        else {
            println("Creating Python virtual environment in ${venvDirFile.absolutePath}...")
            commandLine("python", "-m", "venv", "venv")
        }

        println("Installing Python dependencies from requirements.txt...")
        commandLine(pipExecutable, "install", "-r", "requirements.txt")
    }
}

tasks.register<Exec>("runPythonImporter") {
    description = "Executes the Python data importer script."
    dependsOn(tasks.named("setupPythonVenv"))

    workingDir = importerDir.asFile
    commandLine(
        pythonExecutable,
        "importer.py",
        "ibge-pop.csv",
        "capag.xlsx"
    )

    standardOutput = System.out
    errorOutput = System.err

    environment = mapOf(
        "DB_HOST" to "postgres",
        "DB_NAME" to "postgres",
        "DB_USER" to "root",
        "DB_PASSWORD" to "password"
    )
}