package com.kyukin.ontherock.domain.user.presentation;

import com.kyukin.ontherock.domain.user.presentation.dto.request.UserLoginRequest
import com.kyukin.ontherock.domain.user.presentation.dto.response.TokenResponse
import com.kyukin.ontherock.domain.user.service.UserService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequestMapping("/auth")
class AuthController constructor(
    private val userService: UserService,
) {

    @PostMapping
    fun login(@RequestBody @Valid request: UserLoginRequest): TokenResponse {
        return userService.login(request);
    }
}