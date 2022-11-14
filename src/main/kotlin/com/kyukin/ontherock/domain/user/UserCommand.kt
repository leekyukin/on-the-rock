package com.kyukin.ontherock.domain.user

import com.kyukin.ontherock.domain.user.type.Authority
import com.kyukin.ontherock.infrastructure.image.s3.DefaultProfileImage

class UserCommand {

    data class Join(
        val name: String,
        var nickname: String,
        val email: String,
        var password: String,
        var birthday: String,
        var phoneNumber: String,
        var address: String,
    ) {

        fun toEntity(): User {
            return User(
                name,
                nickname,
                email,
                password,
                Authority.USER,
                birthday,
                phoneNumber,
                address,
                DefaultProfileImage.URL,
            )
        }

    }

    data class Login(
        val email: String,
        val password: String,
    )
}