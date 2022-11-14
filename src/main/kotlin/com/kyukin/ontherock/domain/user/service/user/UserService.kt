package com.kyukin.ontherock.domain.user.service.user

import com.kyukin.ontherock.domain.user.UserCommand
import com.kyukin.ontherock.interfaces.user.dto.UserResponse

interface UserService {
    fun getProfile(): UserResponse.Profile
    fun updateProfileImage(img: UserCommand.UpdateProfileImg)
}