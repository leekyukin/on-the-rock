package com.kyukin.ontherock.domain.user.service

import com.kyukin.ontherock.domain.user.UserCommand
import com.kyukin.ontherock.interfaces.user.dto.UserResponse

interface UserAuthService {
    fun registerUser(command: UserCommand.Join)
    fun login(request: UserCommand.Login): UserResponse.Token
}