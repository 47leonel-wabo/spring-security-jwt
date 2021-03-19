package com.aiwa.ws.services

import com.aiwa.ws.model.User
import com.aiwa.ws.model.request.UserDetails

interface UserService {
    fun createUser(userDetails: UserDetails): User
}