package com.example.api.config

import javax.sql.DataSource
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.ProviderManager
import org.springframework.security.authentication.dao.DaoAuthenticationProvider
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.invoke
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.factory.PasswordEncoderFactories
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.provisioning.JdbcUserDetailsManager
import org.springframework.security.web.SecurityFilterChain

@Configuration
@EnableWebSecurity
class SecurityConfig {

  @Bean
  fun securityFilterChain(http: HttpSecurity): SecurityFilterChain {
    http.csrf { it.disable() }
    http.invoke {
      authorizeHttpRequests {
        authorize("/auth/*", permitAll)
        authorize(anyRequest, authenticated)
      }
    }

    return http.build()
  }

  @Bean
  fun authenticationManager(
      userDetailsService: UserDetailsService,
      passwordEncoder: PasswordEncoder
  ): AuthenticationManager {
    val authenticationProvider = DaoAuthenticationProvider()
    authenticationProvider.setUserDetailsService(userDetailsService)
    authenticationProvider.setPasswordEncoder(passwordEncoder)

    return ProviderManager(authenticationProvider)
  }

  @Bean
  fun userDetailsService(dataSource: DataSource): UserDetailsService {
    return JdbcUserDetailsManager(dataSource)
  }

  @Bean
  fun passwordEncoder(): PasswordEncoder {
    return PasswordEncoderFactories.createDelegatingPasswordEncoder()
  }
}
