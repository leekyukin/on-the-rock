package com.kyukin.ontherock.infrastructure.user

import com.kyukin.ontherock.domain.user.User
import com.kyukin.ontherock.domain.user.UserCommand
import com.kyukin.ontherock.domain.user.design.UserStore
import com.kyukin.ontherock.domain.user.exception.EmailAlreadyExists
import com.kyukin.ontherock.domain.user.exception.NickNameAlreadyExists
import com.kyukin.ontherock.domain.user.exception.PhoneNumberAlreadyExists
import org.springframework.stereotype.Component

@Component
class UserStoreImpl(
    private val userRepository: UserRepository,
): UserStore {

    override fun registerUser(user: User) {
        validateCreateUser(user)
        userRepository.save(user)
    }

    fun validateCreateUser(user: User) {

        if(userRepository.existsByEmail(user.email)) {
            throw EmailAlreadyExists.EXCEPTION
        }

        if(userRepository.existsByPhoneNumber(user.phoneNumber)) {
            throw PhoneNumberAlreadyExists.EXCEPTION
        }

        if(userRepository.existsByNickname(user.nickname)) {
            throw NickNameAlreadyExists.EXCEPTION
        }
    }
}