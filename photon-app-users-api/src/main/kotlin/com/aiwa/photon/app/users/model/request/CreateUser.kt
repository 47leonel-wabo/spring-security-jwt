package com.aiwa.photon.app.users.model.request

import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

data class CreateUser(

        @field:NotBlank(message = "First name is mandatory")
        @field:Size(min = 2, message = "At least 2 characters")
        val firstName: String,

        @field:NotBlank(message = "Last name is mandatory")
        @field:Size(min = 2, message = "At least 2 characters")
        val lastName: String,

        @field:NotBlank(message = "Password is mandatory")
        @field:Size(min = 8, max = 16, message = "Password length between 8-16 characters")
        val password: String,

        @field:Email
        @field:NotBlank(message = "Email is mandatory")
        val email: String
)
