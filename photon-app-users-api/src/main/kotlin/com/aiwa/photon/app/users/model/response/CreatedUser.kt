package com.aiwa.photon.app.users.model.response

data class CreatedUser(
        var userId: String,
        val firstName: String,
        val lastName: String,
        val email: String
)
