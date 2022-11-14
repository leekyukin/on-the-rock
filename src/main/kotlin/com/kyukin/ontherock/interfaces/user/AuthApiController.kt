package com.kyukin.ontherock.interfaces.user;

import com.kyukin.ontherock.domain.user.service.auth.UserAuthService
import com.kyukin.ontherock.interfaces.user.dto.UserAuthRequest
import com.kyukin.ontherock.interfaces.user.dto.UserDtoMapper
import com.kyukin.ontherock.interfaces.user.dto.UserResponse
import org.mapstruct.factory.Mappers
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequestMapping("/api/v1/auth")
class AuthApiController constructor(
    private val userAuthService: UserAuthService,
) {
    private val userDtoMapper = Mappers.getMapper(UserDtoMapper::class.java)

    @PostMapping
    fun joinUser(@RequestBody @Valid request: UserAuthRequest.Join) {
        val userCommand = userDtoMapper.of(request)
        userAuthService.registerUser(userCommand);
    }

    @PostMapping("/login")
    fun login(@RequestBody @Valid request: UserAuthRequest.Login): UserResponse.Token {
        val userCommand = userDtoMapper.of(request)
        return userAuthService.login(userCommand);
    }
}