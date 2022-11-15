package com.kyukin.ontherock.domain.user.service

import com.kyukin.ontherock.domain.user.User
import com.kyukin.ontherock.domain.user.UserCommand
import com.kyukin.ontherock.domain.user.design.UserReader
import com.kyukin.ontherock.interfaces.user.dto.UserResponse
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UserServiceImpl (
    private val userReader: UserReader,
): UserService {

    @Transactional(readOnly = true)
    override fun getProfile(): UserResponse.Profile{
        val user = userReader.getCurrentUser();
        return UserResponse.Profile.of(user)
    }

    @Transactional
    override fun updateProfileImage(command: UserCommand.UpdateProfileImg) {
        val user: User = userReader.getCurrentUser()
        user.updateProfileImage(command.img)
    }
}
