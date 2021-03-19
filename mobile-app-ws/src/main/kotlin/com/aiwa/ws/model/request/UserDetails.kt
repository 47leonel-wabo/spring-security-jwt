package com.aiwa.ws.model.request

import javax.validation.constraints.Email
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

class UserDetails(
        @NotNull(message = "First name should be provided")
        val firstName: String,
        val lastName: String,
        @Email
        val email: String,
        @Size(message = "Password should be between 8 and 16 characters", min = 8)
        val password: String
)