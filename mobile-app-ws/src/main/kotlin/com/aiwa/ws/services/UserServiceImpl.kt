package com.aiwa.ws.services

import com.aiwa.ws.model.User
import com.aiwa.ws.model.request.UserDetails
import com.aiwa.ws.toUser

class UserServiceImpl : UserService {
    override fun createUser(userDetails: UserDetails): User = userDetails.toUser()
}