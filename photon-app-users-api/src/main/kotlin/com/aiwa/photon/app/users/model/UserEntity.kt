package com.aiwa.photon.app.users.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "users")
data class UserEntity(

        @Id
        @GeneratedValue
        var id: Long,

        var userId: String,

        var firstName: String,

        var lastName: String,

        var email: String,

        var encryptedPassword: String
)
