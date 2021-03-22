package com.aiwa.photon.app.users.controller

import com.aiwa.photon.app.users.model.request.CreateUser
import com.aiwa.photon.app.users.model.response.CreatedUser
import com.aiwa.photon.app.users.service.UserServiceImpl
import org.springframework.core.env.Environment
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping(path = ["/users"])
class UserController(val env: Environment, val userService: UserServiceImpl) {

    @GetMapping(path = ["/check/status"])
    fun appStatus(): String = "User service up and running on ${env.getProperty("local.server.port")}"

    @PostMapping(
            consumes = [
                MediaType.APPLICATION_JSON_VALUE,
                MediaType.APPLICATION_XML_VALUE
            ],
            produces = [
                MediaType.APPLICATION_JSON_VALUE,
                MediaType.APPLICATION_XML_VALUE
            ]
    )
    fun createUser(@Valid @RequestBody createUser: CreateUser): ResponseEntity<CreatedUser> {
        val savedUser = userService.createUser(createUser)
        return ResponseEntity(CreatedUser(
                savedUser.userId,
                savedUser.firstName,
                savedUser.lastName,
                savedUser.email
        ), HttpStatus.CREATED)
    }
}
