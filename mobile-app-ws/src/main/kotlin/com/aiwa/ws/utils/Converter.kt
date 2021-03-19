package com.aiwa.ws

import com.aiwa.ws.model.User
import com.aiwa.ws.model.request.UserDetails
import java.util.*

fun UserDetails.toUser(): User = User(
        UUID.randomUUID().toString(),
        this.firstName,
        this.lastName,
        this.email,
)