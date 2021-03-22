package com.aiwa.photon.app.users.dao

import com.aiwa.photon.app.users.model.UserEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository:JpaRepository<UserEntity, Long>
