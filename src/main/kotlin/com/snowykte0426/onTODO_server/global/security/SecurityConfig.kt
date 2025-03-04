package com.snowykte0426.onTODO_server.global.security

import org.springframework.context.annotation.Bean
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.web.SecurityFilterChain
import org.springframework.stereotype.Component
import org.springframework.web.cors.CorsConfiguration
import org.springframework.web.cors.UrlBasedCorsConfigurationSource


@Component
@EnableWebSecurity
class SecurityConfig {

    @Bean
    fun securityFilterChain(http: HttpSecurity): SecurityFilterChain =
        http.run {
            cors { cors ->
                cors.configurationSource {
                    CorsConfiguration().apply {
                        allowedOriginPatterns = listOf("*")
                        allowedMethods = listOf("*")
                        allowedHeaders = listOf("*")
                        allowCredentials = true
                    }.also { config ->
                        UrlBasedCorsConfigurationSource().apply {
                            registerCorsConfiguration("/**", config)
                        }
                    }
                }
            }
            csrf { it.disable() }
            authorizeHttpRequests { it.anyRequest().permitAll() }
            formLogin { it.disable() }
            sessionManagement { it.sessionCreationPolicy(SessionCreationPolicy.STATELESS) }
            httpBasic { it.disable() }
            build()
        }
}