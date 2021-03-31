package com.aiwa.photon.app.users.security

import com.aiwa.photon.app.users.service.UserService
import org.springframework.context.annotation.Configuration
import org.springframework.core.env.Environment
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder

@Configuration
@EnableWebSecurity
class WebSecurity(val env: Environment, val userService: UserService, val bCrypt: BCryptPasswordEncoder) : WebSecurityConfigurerAdapter() {

    override fun configure(http: HttpSecurity?) {
        http?.let {
            it.csrf().disable()
            it.authorizeRequests().antMatchers("/**").hasIpAddress(env.getProperty("gateway.ip"))
                    .and()
                    .addFilter(getAuthenticationFilter())
            it.headers().frameOptions().disable()
        }
    }

    override fun configure(auth: AuthenticationManagerBuilder?) {
        auth?.userDetailsService(userService)?.passwordEncoder(bCrypt)
    }

    private fun getAuthenticationFilter(): AuthenticationFilter =
            AuthenticationFilter().apply {
                authenticationManager()
            }

}
