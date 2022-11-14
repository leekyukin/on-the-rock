package com.kyukin.ontherock.domain.user.service

import com.kyukin.ontherock.domain.user.User
import com.kyukin.ontherock.domain.user.UserCommand
import com.kyukin.ontherock.domain.user.design.UserReader
import com.kyukin.ontherock.domain.user.design.UserStore
import com.kyukin.ontherock.domain.user.exception.PasswordMismatchException
import com.kyukin.ontherock.global.security.jwt.JwtProvider
import com.kyukin.ontherock.interfaces.user.dto.UserAuthRequest
import com.kyukin.ontherock.interfaces.user.dto.UserResponse
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UserService (
    private val passwordEncoder: PasswordEncoder,
    private val jwtProvider: JwtProvider,
    private val userReader: UserReader,
    private val userStore: UserStore,
) {

    @Transactional
    fun createUser(command: UserCommand.Join) {
        val encodedPassword = passwordEncoder.encode(command.password)
        command.password = encodedPassword
        userStore.registerUser(command.toEntity())
    }

    @Transactional(readOnly = true)
    fun login(request: UserAuthRequest.Login): UserResponse.Token {
        val user = userReader.findUserByEmail(request.email)
        checkPassword(request.password, user.password)
        val accessToken = jwtProvider.createAccessToken(request.email)
        return UserResponse.Token(accessToken)
    }

    private fun checkPassword(actual: String, expected: String) {
        if (!passwordEncoder.matches(actual, expected)) {
            throw PasswordMismatchException.EXCEPTION
        }
    }

    @Transactional(readOnly = true)
    fun getProfile(): UserResponse.Profile{
        val user = userReader.getCurrentUser();
        return UserResponse.Profile.of(user)
    }

    @Transactional
    fun updateProfileImage(img: String) {
        val user: User = userReader.getCurrentUser()
        user.updateProfileImage(img)
    }
}
