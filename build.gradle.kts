plugins {
    java
    id("org.springframework.boot") version "3.4.4"
    id("io.spring.dependency-management") version "1.1.7"
    id("org.graalvm.buildtools.native") version "0.9.28"
}

group = "com.arch.library-inventory-ms"
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

tasks.jar {
    manifest {
        attributes["Main-Class"] = "com.arch.library.inventory.ms.Application"
    }
}

tasks.bootJar {
    mainClass.set("com.arch.library.inventory.ms.Application")
}

springBoot() {
    mainClass.set("com.arch.library.inventory.ms.Application")
}

repositories {
    mavenCentral()
}

extra["springCloudGcpVersion"] = "6.1.1"
extra["springCloudVersion"] = "2024.0.1"

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-actuator")
    
    
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    runtimeOnly("org.postgresql:postgresql")
    
    implementation("com.google.cloud:spring-cloud-gcp-starter-pubsub")
    implementation("com.google.cloud:spring-cloud-gcp-pubsub-stream-binder")
    implementation("org.springframework.boot:spring-boot-starter-web") {
        exclude(group = "org.springframework.boot", module = "spring-boot-starter-tomcat")
    }
    implementation("org.springframework.boot:spring-boot-starter-jetty")
    compileOnly("org.projectlombok:lombok")
    developmentOnly("org.springframework.boot:spring-boot-devtools")
    annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")
    annotationProcessor("org.projectlombok:lombok")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.springframework.cloud:spring-cloud-stream-test-binder")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

dependencyManagement {
    imports {
        mavenBom("com.google.cloud:spring-cloud-gcp-dependencies:${property("springCloudGcpVersion")}")
        mavenBom("org.springframework.cloud:spring-cloud-dependencies:${property("springCloudVersion")}")
    }
}

tasks.bootBuildImage {
    builder.set("docker.io/paketobuildpacks/builder-jammy-base")
    imageName = "${project.name}"
    environment = mapOf("BP_JVM_VERSION" to "21")
    docker {
        publishRegistry {
            username = project.findProperty("registryUsername").toString()
            password = project.findProperty("registryToken").toString()
            url = project.findProperty("registryUrl").toString()
        }
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}
