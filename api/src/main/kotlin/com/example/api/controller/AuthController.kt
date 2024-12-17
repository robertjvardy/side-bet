package com.example.api.controller

import com.example.api.Dtos.LoginRequest
import org.springframework.http.ResponseEntity
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/auth")
class LoginController(val authenticationManager: AuthenticationManager) {

  @PostMapping("login")
  fun login(@RequestBody loginRequest: LoginRequest): ResponseEntity<Authentication> {
    val authenticationRequest =
        UsernamePasswordAuthenticationToken.unauthenticated(
            loginRequest.username, loginRequest.password)
    val authenticationResponse = authenticationManager.authenticate(authenticationRequest)
    return ResponseEntity.ok(authenticationResponse)
  }
}
