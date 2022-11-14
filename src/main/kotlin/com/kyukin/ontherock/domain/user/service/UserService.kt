package com.kyukin.ontherock.domain.user.service

import com.kyukin.ontherock.domain.user.User
import com.kyukin.ontherock.domain.user.UserCommand
import com.kyukin.ontherock.domain.user.exception.PasswordMismatchException
import com.kyukin.ontherock.domain.user.facade.UserFacade
import com.kyukin.ontherock.global.security.jwt.JwtProvider
import com.kyukin.ontherock.infrastructure.user.UserRepository
import com.kyukin.ontherock.interfaces.user.dto.UserAuthRequest
import com.kyukin.ontherock.interfaces.user.dto.UserDtoMapper
import com.kyukin.ontherock.interfaces.user.dto.UserResponse
import org.mapstruct.factory.Mappers
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UserService (
    private val userRepository: UserRepository,
    private val userFacade: UserFacade,
    private val passwordEncoder: PasswordEncoder,
    private val jwtProvider: JwtProvider,
) {

    @Transactional
    fun createUser(command: UserCommand.Join) {
        userFacade.validateCreateUser(command)
        command.password = passwordEncoder.encode(command.password)
        userRepository.save(command.toEntity());
    }

    @Transactional(readOnly = true)
    fun login(request: UserAuthRequest.Login): UserResponse.Token {

        val user = userFacade.findUserByEmail(request.email)
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
        val user = userFacade.getCurrentUser();
        return UserResponse.Profile.of(user)
    }

    @Transactional
    fun updateProfileImage(img: String) {
        val user: User = userFacade.getCurrentUser()
        user.updateProfileImage(img)
    }
}
