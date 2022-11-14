package com.kyukin.ontherock.domain.user.facade

import com.kyukin.ontherock.domain.user.User
import com.kyukin.ontherock.domain.user.UserCommand
import com.kyukin.ontherock.infrastructure.user.UserRepository
import com.kyukin.ontherock.global.security.auth.AuthDetails
import com.kyukin.ontherock.domain.user.exception.EmailAlreadyExists
import com.kyukin.ontherock.domain.user.exception.NickNameAlreadyExists
import com.kyukin.ontherock.domain.user.exception.PhoneNumberAlreadyExists
import com.kyukin.ontherock.domain.user.exception.UserNotFoundException
import com.kyukin.ontherock.interfaces.user.dto.UserAuthRequest
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Component

@Component
class UserFacade constructor(
    private val userRepository: UserRepository,
){

    fun validateCreateUser(command: UserCommand.Join) {

        if(userRepository.existsByEmail(command.email)) {
            throw EmailAlreadyExists.EXCEPTION
        }

        if(userRepository.existsByPhoneNumber(command.phoneNumber)) {
            throw PhoneNumberAlreadyExists.EXCEPTION
        }

        if(userRepository.existsByNickname(command.nickname)) {
            throw NickNameAlreadyExists.EXCEPTION
        }
    }

    fun findUserByEmail(email: String): User {
        return userRepository.findByEmail(email)
            ?: throw UserNotFoundException.EXCEPTION
    }

    fun getCurrentUser(): User {
        val auth: AuthDetails = SecurityContextHolder.getContext().authentication.principal
                as AuthDetails
        return findUserByEmail(auth.username)
    }
}
