package com.kyukin.ontherock.domain.user.service

import com.kyukin.ontherock.domain.user.UserCommand
import com.kyukin.ontherock.domain.user.design.UserReader
import com.kyukin.ontherock.domain.user.design.UserStore
import com.kyukin.ontherock.domain.user.exception.PasswordMismatchException
import com.kyukin.ontherock.global.security.jwt.JwtProvider
import com.kyukin.ontherock.interfaces.user.dto.UserResponse
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UserAuthServiceImpl(
    private val passwordEncoder: PasswordEncoder,
    private val userStore: UserStore,
    private val userReader: UserReader,
    private val jwtProvider: JwtProvider,
): UserAuthService {

    @Transactional
    override fun registerUser(command: UserCommand.Join) {
        val encodedPassword = passwordEncoder.encode(command.password)
        command.password = encodedPassword
        userStore.registerUser(command.toEntity())
    }

    @Transactional(readOnly = true)
    override fun login(command: UserCommand.Login): UserResponse.Token {
        val user = userReader.findUserByEmail(command.email)
        checkPassword(command.password, user.password)
        val accessToken = jwtProvider.createAccessToken(command.email)
        return UserResponse.Token(accessToken)
    }

    private fun checkPassword(actual: String, expected: String) {
        if (!passwordEncoder.matches(actual, expected)) {
            throw PasswordMismatchException.EXCEPTION
        }
    }
}