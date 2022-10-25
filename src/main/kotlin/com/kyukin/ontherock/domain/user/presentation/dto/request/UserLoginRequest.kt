package com.kyukin.ontherock.domain.user.presentation.dto.request

import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank

data class UserLoginRequest (

    @field: Email
    val email: String,

    @field: NotBlank
    val password: String,
)
