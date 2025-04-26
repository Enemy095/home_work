plugins {
    java
    id("java")
//    id("org.springframework.boot") version "3.4.3"
//    id("io.spring.dependency-management") version "1.1.7"

}

group = "org.work"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
//    implementation("org.springframework.boot:spring-boot-starter-data-jdbc")
//    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation("org.projectlombok:lombok:1.18.26")
    annotationProcessor("org.projectlombok:lombok:1.18.26")
    implementation("org.hibernate:hibernate-core:5.6.15.Final")
    implementation ("org.postgresql:postgresql:42.5.4")
    implementation("org.liquibase:liquibase-core:4.20.0")

    /**
     * Database
     */
    runtimeOnly("org.postgresql:postgresql")

//    /**
//     * Utils & Logging
//     */
//    implementation("org.slf4j:slf4j-api:2.0.5")
//    implementation("org.mapstruct:mapstruct:1.5.3.Final")
//    annotationProcessor("org.mapstruct:mapstruct-processor:1.5.3.Final")

}

tasks.test {
    useJUnitPlatform()
}