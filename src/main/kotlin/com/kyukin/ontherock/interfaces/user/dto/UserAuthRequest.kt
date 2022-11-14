package com.kyukin.ontherock.interfaces.user.dto

import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank

class UserAuthRequest {

    data class Join (
        @field:NotBlank
        val name: String,

        @field:NotBlank
        var nickname: String,

        @field:Email
        val email: String,

        @field:NotBlank
        var password: String,

        @field:NotBlank
        var birthday: String,

        @field:NotBlank
        var phoneNumber: String,

        @field:NotBlank
        var address: String,
    )

    data class Login (
        @field: Email
        val email: String,

        @field: NotBlank
        val password: String,
    )
}