package com.aiwa.ws.controller

import com.aiwa.ws.model.User
import com.aiwa.ws.model.request.UserDetails
import com.aiwa.ws.toUser
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping(path = ["/users"])
class AppController {

    private var users: MutableMap<String, User> = HashMap()

    @GetMapping(
            path = ["/{userId}"],
            produces = [
                MediaType.APPLICATION_JSON_VALUE,
                MediaType.APPLICATION_XML_VALUE
            ]
    )
    fun fetchUser(@PathVariable userId: String): ResponseEntity<Any> {
        return if (users.isNotEmpty() && users.containsKey(userId))
            ResponseEntity(users.getValue(userId), HttpStatus.OK)
        else ResponseEntity(HttpStatus.NOT_FOUND)
    }


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
                MediaType.APPLICATION_JSON_VALUE,
                MediaType.APPLICATION_XML_VALUE
            ],
            produces = [
                MediaType.APPLICATION_JSON_VALUE,
                MediaType.APPLICATION_XML_VALUE
            ]
    )
    fun create(@Valid @RequestBody userDetails: UserDetails): ResponseEntity<User> {
        val user = userDetails.toUser()
        users[user.id] = user
        return ResponseEntity.ok(user)
    }

}