import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
//buildscript {
//    repositories {
//        jcenter()
//    }
//
//    dependencies {
//        classpath 'nu.studer:gradle-jooq-plugin:1.0.+'
//        classpath 'org.apache.derby:derby:10.11.1.1'
//    }
//    configurations.classpath {
//        resolutionStrategy {                            // enforce a specific jOOQ version
//            forcedModules = [
//                    'org.jooq:jooq:3.7.+',
//                    'org.jooq:jooq-meta:3.7.+',
//                    'org.jooq:jooq-codegen:3.7.+'
//            ]
//        }
//    }
//}

plugins {
    id("org.springframework.boot") version "2.2.1.RELEASE"
    id("io.spring.dependency-management") version "1.0.8.RELEASE"
    
//    id("nu.studer.jooq") version "3.0.3"
    war
    kotlin("jvm") version "1.3.61"
    kotlin("plugin.spring") version "1.3.61"
}

group = "com.abopu"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_12

val developmentOnly by configurations.creating
configurations {
    runtimeClasspath {
        extendsFrom(developmentOnly)
    }
}

repositories {
    mavenCentral()
}

dependencies {
//    implementation("org.springframework.boot:spring-boot-starter-jooq")
    implementation(project(":data-manager"))
    implementation("org.springframework.boot:spring-boot-starter-thymeleaf")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-websocket")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    developmentOnly("org.springframework.boot:spring-boot-devtools")
    runtimeOnly("org.postgresql:postgresql")
    providedRuntime("org.springframework.boot:spring-boot-starter-tomcat")
    testImplementation("org.springframework.boot:spring-boot-starter-test") {
        exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
    }

    // Logging
    implementation("org.slf4j:slf4j-api")
    implementation("ch.qos.logback:logback-classic")
    implementation("ch.qos.logback:logback-core")
//    
//    // Logging
//    compile group: 'org.slf4j', name: 'slf4j-api', version: '1.7.+'
//    compile group: 'ch.qos.logback', name: 'logback-classic', version: '1.+'
//    runtime group: 'org.codehaus.groovy', name: 'groovy-all', version: '2.4.+'
//
//    // Testing
//    testCompile group: 'junit', name: 'junit', version: '4.+'
//
//    // Servlet
//    compile group: 'javax.servlet', name: 'javax.servlet-api', version: '3.1.+'
//    compile group: 'org.glassfish.jersey.core', name: 'jersey-server', version: '2.22.+'
//    compile group: 'org.glassfish.jersey.containers', name: 'jersey-container-servlet', version: '2.22.+'
//    compile group: 'org.glassfish.jersey.ext', name: 'jersey-servlet-portability', version: '2.22.+'
//    compile group: 'org.glassfish.jersey.media', name: 'jersey-media-multipart', version: '2.22.+'
//    compile group: 'org.glassfish.jersey.media', name: 'jersey-media-json-jackson', version: '2.22.+'
//
//    // Servlet Filters
//    compile 'org.tuckey:urlrewritefilter:4.0.+'
//
//    // Security
//    compile group: 'org.mindrot', name: 'jbcrypt', version: '0.3m'
//
//    // Database
////    runtime group: 'org.apache.derby', name: 'derby', version: '10.11.1.1'
//    jooqRuntime 'postgresql:postgresql:9.1-901-1.jdbc4'
//    compile 'org.jooq:jooq:3.11.9'
//    compile 'org.jooq:jooq-meta:3.11.9'
//    compile 'org.jooq:jooq-codegen:3.11.9'
}

tasks.withType<Test> {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "1.8"
    }
}

//sourceSets {
//    main {
//        java {
//            srcDirs += 'src/main/generated/java'
//        }
//    }
//}
//
//task explodedWar(type: Copy) {
//    group = 'build'
//    into new File(buildDir, 'exploded-war')
//    with war
//}
//
//jooq {
//    version = '3.11.9'
//    edition = 'OSS'
//    sample(sourceSets.main) {
//        jdbc {
//            driver = 'org.postgresql.Driver'
//            url = 'jdbc:postgresql://192.168.2.9:5432/booru'
//            user = 'booru'
//            password = '3uwr8prA'
//        }
//        generator {
//            name = 'org.jooq.codegen.DefaultGenerator'
//            strategy {
//                name = 'org.jooq.codegen.DefaultGeneratorStrategy'
//                // ...
//            }
//            database {
//                name = 'org.jooq.meta.postgres.PostgresDatabase'
//                inputSchema = 'recipebook'
//                forcedTypes {
//                    forcedType {
//                        name = 'varchar'
//                        expression = '.*'
//                        types = 'JSONB?'
//                    }
//                    forcedType {
//                        name = 'varchar'
//                        expression = '.*'
//                        types = 'INET'
//                    }
//                }
//                // ...
//            }
//            generate {
//                relations = true
//                deprecated = false
//                records = true
//                immutablePojos = true
//                fluentSetters = true
//                // ...
//            }
//            target {
//                packageName = 'com.abopu.booru'
//                directory = 'src/main/generated'
//            }
//        }
//    }
//}
//
//idea {
//    module {
//        generatedSourceDirs += file('src/main/generated')
//    }
//}