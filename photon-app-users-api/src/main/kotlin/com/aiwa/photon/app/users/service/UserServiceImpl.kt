package com.aiwa.photon.app.users.service

import com.aiwa.photon.app.users.dao.UserRepository
import com.aiwa.photon.app.users.model.UserEntity
import com.aiwa.photon.app.users.model.dto.UserDetailsDto
import com.aiwa.photon.app.users.model.request.CreateUser
import org.springframework.stereotype.Service
import java.util.*

@Service
class UserServiceImpl(val userRepository: UserRepository) : UserService {

    override fun createUser(userDetails: CreateUser): UserDetailsDto {
        val userDetailsDto = UserDetailsDto(
                UUID.randomUUID().toString(),
                userDetails.firstName,
                userDetails.lastName,
                userDetails.password,
                userDetails.email,
                "pass not encrypted"
        )
        userRepository.save(UserEntity(0, userDetailsDto.userId, userDetailsDto.firstName, userDetailsDto.lastName, userDetailsDto.email, userDetailsDto.encryptedPassword))
        return userDetailsDto
    }

}
