package com.aiwa.ws.controller

import com.aiwa.ws.model.User
import com.aiwa.ws.model.request.UserDetails
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(path = ["/users"])
class AppController {

    @GetMapping(
            path = ["/{userId}"],
            produces = [MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE]
    )
    fun fetchUser(@PathVariable userId: Long): ResponseEntity<User> =
            ResponseEntity(
                    User(id = userId, "leo", "ka", "leo-ka@mail.com"),
                    HttpStatus.OK
            )

    @GetMapping
    fun fetchUsers(
            @RequestParam(name = "page") page: Int,
            @RequestParam(name = "limit", defaultValue = "20") limit: Int,
            @RequestParam(name = "sort", defaultValue = "DESC", required = false) sort: String
    ): String = "get users called on page $page, and limit to $limit, sort order $sort"

    @PutMapping
    fun update(): String = "update user called"

    @DeleteMapping
    fun delete(): String = "delete user called"

    @PostMapping(
            consumes = [
                MediaType.APPLICATION_JSON_VALUE
            ],
            produces = [
                MediaType.APPLICATION_JSON_VALUE,
                MediaType.APPLICATION_XML_VALUE
            ]
    )
    fun create(@RequestBody userDetails: UserDetails): ResponseEntity<User> =
            ResponseEntity.ok(User(1, userDetails.firstName, userDetails.lastName, userDetails.email))

}