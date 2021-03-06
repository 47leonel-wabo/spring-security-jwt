package com.aiwa.photon.app.users.service

import com.aiwa.photon.app.users.dao.UserRepository
import com.aiwa.photon.app.users.model.UserEntity
import com.aiwa.photon.app.users.model.dto.UserDetailsDto
import com.aiwa.photon.app.users.model.request.CreateUser
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service
import java.util.*

@Service
class UserServiceImpl(val userRepository: UserRepository, val passwordEncoder: BCryptPasswordEncoder) : UserService {

    override fun createUser(userDetails: CreateUser): UserDetailsDto {
        val userDetailsDto = UserDetailsDto(
                UUID.randomUUID().toString(),
                userDetails.firstName,
                userDetails.lastName,
                userDetails.password,
                userDetails.email,
                passwordEncoder.encode(userDetails.password)
        )
        userRepository.save(UserEntity(0, userDetailsDto.userId, userDetailsDto.firstName, userDetailsDto.lastName, userDetailsDto.email, userDetailsDto.encryptedPassword))
        return userDetailsDto
    }

    override fun loadUserByUsername(username: String?): UserDetails {
        val userEntity = username?.let { userRepository.findByEmail(it) }
        return User(userEntity?.email, userEntity?.encryptedPassword, true, true, true, true, arrayListOf())
    }

}
