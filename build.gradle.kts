plugins {
    id("java")
}

group = "org.work"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation("org.projectlombok:lombok:1.18.26")
    annotationProcessor("org.projectlombok:lombok:1.18.26")
//    compileOnly("org.projectlombok:lombok")
//    annotationProcessor("org.projectlombok:lombok")

}

tasks.test {
    useJUnitPlatform()
}