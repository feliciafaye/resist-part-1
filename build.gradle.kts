plugins {
    kotlin("jvm") version "1.6.21"
    kotlin("plugin.allopen") version "1.6.21"
    id("io.quarkus")
}

repositories {
    mavenCentral()
    mavenLocal()
}

val quarkusPlatformGroupId: String by project
val quarkusPlatformArtifactId: String by project
val quarkusPlatformVersion: String by project

dependencies {
    implementation(enforcedPlatform("${quarkusPlatformGroupId}:${quarkusPlatformArtifactId}:${quarkusPlatformVersion}"))
    implementation("io.quarkus:quarkus-resteasy-reactive-jackson:2.8.3.Final")
    implementation("io.quarkus:quarkus-smallrye-reactive-messaging-amqp:2.8.3.Final")
    implementation("io.quarkus:quarkus-resteasy-reactive:2.8.1.Final")
    implementation("io.quarkus:quarkus-smallrye-fault-tolerance:2.8.3.Final")
    implementation("io.quarkus:quarkus-kotlin:2.8.3.Final")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("io.quarkus:quarkus-arc:2.8.3.Final")
    implementation("io.smallrye.reactive:mutiny-kotlin:1.4.0")
    implementation("io.quarkus:quarkus-smallrye-health:2.8.3.Final")
    
    testImplementation("io.quarkus:quarkus-junit5:2.8.3.Final")
    testImplementation("io.rest-assured:rest-assured:5.0.1")
}

group = "de.faye"
version = "1.0.0-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

allOpen {
    annotation("javax.ws.rs.Path")
    annotation("javax.enterprise.context.ApplicationScoped")
    annotation("io.quarkus.test.junit.QuarkusTest")
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions.jvmTarget = JavaVersion.VERSION_11.toString()
    kotlinOptions.javaParameters = true
    kotlinOptions.freeCompilerArgs += "-opt-in=kotlin.RequiresOptIn"
}
