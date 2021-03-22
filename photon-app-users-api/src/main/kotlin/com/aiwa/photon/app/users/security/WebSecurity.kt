package com.aiwa.photon.app.users.security

import org.springframework.context.annotation.Configuration
import org.springframework.core.env.Environment
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter

@Configuration
@EnableWebSecurity
class WebSecurity(val env: Environment) : WebSecurityConfigurerAdapter(){

    override fun configure(http: HttpSecurity?) {
        http?.let {
            it.csrf().disable()
            it.authorizeRequests().antMatchers("/**").hasIpAddress(env.getProperty("gateway.ip"))
            it.headers().frameOptions().disable()
        }
    }

}
