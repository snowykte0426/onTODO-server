object Dependencies{
    const val SPRING_BOOT_STARTER_WEB =
        "org.springframework.boot:spring-boot-starter-web"
    const val SPRING_BOOT_STARTER_DATA_JPA =
        "org.springframework.boot:spring-boot-starter-data-jpa"
    const val SPRING_BOOT_STARTER_VALIDATION =
        "org.springframework.boot:spring-boot-starter-validation"
    const val SPRING_BOOT_STARTER_SECURITY =
        "org.springframework.boot:spring-boot-starter-security"

    const val JACKSON_MODULE_KOTLIN =
        "com.fasterxml.jackson.module:jackson-module-kotlin:${DependencyVersion.JACKSON_VERSION}"

    const val KOTLIN_REFLECT = "org.jetbrains.kotlin:kotlin-reflect:${DependencyVersion.KOTLIN_REFLECT_VERSION}"

    const val MYSQL_CONNECTOR_J = "com.mysql:mysql-connector-j:${DependencyVersion.MYSQL_CONNECTOR_J_VERSION}"
    const val MARIA_DB_JDBC = "org.mariadb.jdbc:mariadb-java-client:${DependencyVersion.MARIA_DB_JDBC_VERSION}"

    const val SPRING_BOOT_STARTER_TEST =
        "org.springframework.boot:spring-boot-starter-test"
    const val SPRING_SECURITY_TEST =
        "org.springframework.security:spring-security-test"
    const val KOTLIN_TEST_JUNIT5 = "org.jetbrains.kotlin:kotlin-test-junit5:${DependencyVersion.KOTLIN_TEST_JUNIT5_VERSION}"
    const val JUNIT_PLATFORM_LAUNCHER =
        "org.junit.platform:junit-platform-launcher:${DependencyVersion.JUNIT_PLATFORM_VERSION}"

}