@file:Suppress("DEPRECATION")

import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
	plugins {
		id("org.springframework.boot") version "2.2.6.RELEASE"
		id("io.spring.dependency-management") version "1.0.9.RELEASE"
		kotlin("jvm") version "1.3.71"
		kotlin("plugin.spring") version "1.3.71"
	}

	group = "com.example"
	version = "0.0.1-SNAPSHOT"
	java.sourceCompatibility = JavaVersion.VERSION_1_8
	repositories {
		mavenCentral()
		jcenter()
	}

	dependencies {
		implementation("org.springframework.boot:spring-boot-starter-actuator")
		implementation("org.springframework.boot:spring-boot-starter-cache")
		implementation("org.springframework.boot:spring-boot-starter-data-redis-reactive")
		implementation("io.projectreactor.kotlin:reactor-kotlin-extensions")
		implementation("org.jetbrains.kotlin:kotlin-reflect")
		implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
		implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor")
		testImplementation("org.springframework.boot:spring-boot-starter-test") {
			exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
		}
		testImplementation("io.projectreactor:reactor-test")
		implementation("com.expediagroup:graphql-kotlin-spring-server:2.0.0")
		implementation("com.expediagroup:graphql-kotlin-schema-generator")
		implementation("com.apollographql.apollo:apollo-runtime:0.4.1")
		compileOnly("io.github.enigmatis:graphql-spring-annotations:0.1.5")
		implementation("com.expedia:graphql-kotlin:0.6.1")
		implementation("com.graphql-java:graphql-java:13.0")
		implementation("com.graphql-java:graphql-java-extended-scalars:1.0.1")
		// If not already on your classpath, you might need the jetbrains annotations
		compileOnly("org.jetbrains:annotations:13.0")
		testCompileOnly("org.jetbrains:annotations:13.0")
		runtime ("com.graphql-java-kickstart:graphiql-spring-boot-starter:7.0.1")
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