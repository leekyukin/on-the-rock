package com.kyukin.ontherock.infrastructure.user

import com.kyukin.ontherock.domain.user.User
import com.kyukin.ontherock.domain.user.design.UserReader
import com.kyukin.ontherock.domain.user.exception.UserNotFoundException
import com.kyukin.ontherock.global.security.auth.AuthDetails
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Component

@Component
class UserReaderImpl(
    private val userRepository: UserRepository,
): UserReader {

    override fun findUserByEmail(email: String): User {
        return userRepository.findByEmail(email)
            ?: throw UserNotFoundException.EXCEPTION
    }

    override fun getCurrentUser(): User {
        val auth = SecurityContextHolder.getContext().authentication.principal
            as AuthDetails
        return findUserByEmail(auth.username)
    }
}