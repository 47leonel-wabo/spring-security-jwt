package com.aiwa.photon.app.users.model

import javax.persistence.*

@Entity
@Table(name = "users")
data class UserEntity(

        @Id
        @GeneratedValue
        var id: Long,

        var userId: String,

        var firstName: String,

        var lastName: String,

        @Column(unique = true)
        var email: String,

        var encryptedPassword: String
)
