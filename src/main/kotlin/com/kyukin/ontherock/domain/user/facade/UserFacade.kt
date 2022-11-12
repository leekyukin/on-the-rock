package com.kyukin.ontherock.domain.user.facade

import com.kyukin.ontherock.domain.user.domain.User
import com.kyukin.ontherock.domain.user.domain.repository.UserRepository
import com.kyukin.ontherock.domain.user.presentation.dto.request.UserJoinRequest
import com.kyukin.ontherock.global.security.auth.AuthDetails
import com.kyukin.ontherock.domain.user.exception.EmailAlreadyExists
import com.kyukin.ontherock.domain.user.exception.NickNameAlreadyExists
import com.kyukin.ontherock.domain.user.exception.PhoneNumberAlreadyExists
import com.kyukin.ontherock.domain.user.exception.UserNotFoundException
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Component

@Component
class UserFacade constructor(
    private val userRepository: UserRepository,
){

    fun validateCreateUser(request: UserJoinRequest) {

        if(userRepository.existsByEmail(request.email)) {
            throw EmailAlreadyExists.EXCEPTION
        }

        if(userRepository.existsByPhoneNumber(request.phoneNumber)) {
            throw PhoneNumberAlreadyExists.EXCEPTION
        }

        if(userRepository.existsByNickname(request.nickname)) {
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
