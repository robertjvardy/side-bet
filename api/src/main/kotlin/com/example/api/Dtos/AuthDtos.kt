package com.example.api.Dtos

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties("jwt")
data class JwtProperties(
    val key: String,
    val accessTokenExpiration: Long,
    val refreshTokenExpiration: Long,
)

data class LoginRequest(val username: String, val password: String)

data class AuthenticationResponse(
    val accessToken: String,
)
