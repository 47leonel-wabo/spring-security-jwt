package com.aiwa.photon.app.users.service

import com.aiwa.photon.app.users.model.dto.UserDetailsDto
import com.aiwa.photon.app.users.model.request.CreateUser
import org.springframework.security.core.userdetails.UserDetailsService

interface UserService: UserDetailsService {
    fun createUser(userDetails: CreateUser): UserDetailsDto
}
