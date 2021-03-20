package com.aiwa.photon.app.users.controller

import org.springframework.core.env.Environment
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.net.InetAddress

@RestController
@RequestMapping(path = ["/users"])
class UserController(val env: Environment) {

    @GetMapping(path = ["/check/status"])
    fun appStatus(): String = "User service up and running on ${env.getProperty("local.server.port")}"

}
