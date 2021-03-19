package com.aiwa.photon.app.users.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(path = ["/users"])
class UserController {

    @GetMapping(path = ["/check/status"])
    fun appStatus(): String = "User service up and running..."

}