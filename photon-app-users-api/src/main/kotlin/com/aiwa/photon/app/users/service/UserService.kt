package com.aiwa.photon.app.users.service

import com.aiwa.photon.app.users.model.dto.UserDetailsDto
import com.aiwa.photon.app.users.model.request.CreateUser

interface UserService {
    fun createUser(userDetails: CreateUser): UserDetailsDto
}
