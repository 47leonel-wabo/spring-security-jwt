package com.aiwa.photon.app.users.model.dto

data class UserDetailsDto(
        var userId: String,
        val firstName: String,
        val lastName: String,
        val password: String,
        val email: String,
        var encryptedPassword: String
)
