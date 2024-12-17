// package com.example.api.service
//
// import com.example.api.Dtos.AuthenticationResponse
// import com.example.api.Dtos.LoginRequest
// import org.springframework.security.authentication.AuthenticationManager
// import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
// import org.springframework.stereotype.Service
//
// @Service
// class AuthenticationService(val authenticationManager: AuthenticationManager) {
//
//  fun authenticate(loginRequest: LoginRequest): AuthenticationResponse {
//
//    authenticationManager.authenticate(
//        UsernamePasswordAuthenticationToken(loginRequest.username, loginRequest.password))
//
//      return AuthenticationResponse(accessToken = )
//  }
// }
