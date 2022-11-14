package com.kyukin.ontherock.application.user

import com.kyukin.ontherock.domain.user.service.user.UserServiceImpl
import org.springframework.stereotype.Component

@Component
class UserFacade constructor(
    private val userServiceImpl: UserServiceImpl,
) {

    fun registerUser() {

    }
}