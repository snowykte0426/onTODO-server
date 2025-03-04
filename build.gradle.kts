plugins {
	kotlin("jvm") version "1.9.25"
	kotlin("plugin.spring") version "1.9.25"
	id("org.springframework.boot") version "3.4.3"
	id("io.spring.dependency-management") version "1.1.7"
	kotlin("plugin.jpa") version "1.9.25"
	id("org.jetbrains.kotlin.kapt") version "2.1.10"
	id("org.jetbrains.kotlin.plugin.noarg") version "1.9.25"
}

group = "com.snowykte0426"
version = "0.0.1-SNAPSHOT"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(17)
	}
}

repositories {
	mavenCentral()
}

dependencies {
	implementation(Dependencies.SPRING_BOOT_STARTER_VALIDATION)
	implementation(Dependencies.SPRING_BOOT_STARTER_DATA_JPA)
	implementation(Dependencies.SPRING_BOOT_STARTER_SECURITY)
	implementation(Dependencies.SPRING_BOOT_STARTER_WEB)

	implementation(Dependencies.JACKSON_MODULE_KOTLIN)
	implementation(Dependencies.KOTLIN_REFLECT)

	implementation(Dependencies.MYSQL_CONNECTOR_J)
	implementation(Dependencies.MARIA_DB_JDBC)

	testImplementation(Dependencies.SPRING_BOOT_STARTER_TEST)
	testImplementation(Dependencies.KOTLIN_TEST_JUNIT5)
	testRuntimeOnly(Dependencies.JUNIT_PLATFORM_LAUNCHER)
	testImplementation(Dependencies.SPRING_SECURITY_TEST)
}

kotlin {
	compilerOptions {
		freeCompilerArgs.addAll("-Xjsr305=strict")
	}
}

allOpen {
	annotation("jakarta.persistence.Entity")
	annotation("jakarta.persistence.MappedSuperclass")
	annotation("jakarta.persistence.Embeddable")
}

tasks.withType<Test> {
	useJUnitPlatform()
}
