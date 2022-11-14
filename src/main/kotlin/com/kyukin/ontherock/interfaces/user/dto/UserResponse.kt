package com.kyukin.ontherock.interfaces.user.dto

import com.kyukin.ontherock.domain.user.User

class UserResponse {

    data class Token (
        val accessToken: String,
    )

    class Profile (
        val name: String,
        var nickname: String,
        val email: String,
        var birthday: String,
        var phoneNumber: String,
        var address: String,
    ) {
        companion object {
            fun of(user: User): Profile {
                return Profile(
                    user.name,
                    user.nickname,
                    user.email,
                    user.birthday,
                    user.phoneNumber,
                    user.address,
                )
            }
        }
    }
}