package com.aiwa.photon.app.users.security

import com.aiwa.photon.app.users.model.request.LoginDetails
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class AuthenticationFilter : UsernamePasswordAuthenticationFilter() {

    override fun attemptAuthentication(
            request: HttpServletRequest?,
            response: HttpServletResponse?): Authentication {

        val credentials: LoginDetails = ObjectMapper().readValue(request?.inputStream, LoginDetails::class.java)
        println("Credentials => $credentials")

        return authenticationManager.authenticate(UsernamePasswordAuthenticationToken(credentials.email, credentials.password, listOf()))
    }

    override fun successfulAuthentication(
            request: HttpServletRequest?,
            response: HttpServletResponse?,
            chain: FilterChain?,
            authResult: Authentication?) {

        super.successfulAuthentication(request, response, chain, authResult)
    }

}
