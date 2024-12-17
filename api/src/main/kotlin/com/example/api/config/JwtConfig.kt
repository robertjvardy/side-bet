package com.example.api.config

import com.example.api.Dtos.JwtProperties
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Configuration

@Configuration @EnableConfigurationProperties(JwtProperties::class) class JwtConfig
