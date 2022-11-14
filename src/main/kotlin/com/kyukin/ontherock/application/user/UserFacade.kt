package com.kyukin.ontherock.application.user

import com.kyukin.ontherock.domain.user.service.UserService
import org.springframework.stereotype.Component

@Component
class UserFacade constructor(
    private val userService: UserService,
) {

    fun registerUser() {

    }
}