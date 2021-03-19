package com.aiwa.ws.controller

import com.aiwa.ws.model.User
import com.aiwa.ws.model.request.UpdateDetails
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

    @PutMapping(
            path = ["/{userId}"],
            consumes = [
                MediaType.APPLICATION_JSON_VALUE,
                MediaType.APPLICATION_XML_VALUE
            ],
            produces = [
                MediaType.APPLICATION_JSON_VALUE,
                MediaType.APPLICATION_XML_VALUE
            ]
    )
    fun update(@PathVariable userId: String, @Valid @RequestBody updateDetails: UpdateDetails): ResponseEntity<Any> {
        return if (users.isNotEmpty() && users.containsKey(userId)) {

            val user = users[userId]
            user?.firstName = updateDetails.firstName
            user?.lastName = updateDetails.lastName

            user?.let {
                users.put(userId, it)
            }

            ResponseEntity(user, HttpStatus.OK)  // This las instruction iis considered as return
        } else
            ResponseEntity("No Resources", HttpStatus.BAD_REQUEST)
    }

    @DeleteMapping(
            path = ["/{userId}"],
            produces = [
                MediaType.APPLICATION_JSON_VALUE,
                MediaType.APPLICATION_XML_VALUE
            ]
    )
    fun delete(@PathVariable userId: String): ResponseEntity<Any> {
        return if (users.isNotEmpty() && users.containsKey(userId)) {
            val user = users.remove(userId)
            ResponseEntity("User with id $userId removed", HttpStatus.OK)  // This las instruction iis considered as return
        } else
            ResponseEntity("No Resources", HttpStatus.BAD_REQUEST)

    }

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