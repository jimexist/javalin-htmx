plugins {
    kotlin("jvm") version "1.7.21"
    application
}

version = "1.0.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("io.javalin:javalin:5.2.0")
    implementation("io.javalin:javalin-rendering:5.2.0")
    implementation("org.slf4j:slf4j-simple:2.0.3")
    implementation("com.github.spullara.mustache.java:compiler:0.9.10")

}

application {
    mainClass.set("me.jiayu.javalin.AppKt")
}