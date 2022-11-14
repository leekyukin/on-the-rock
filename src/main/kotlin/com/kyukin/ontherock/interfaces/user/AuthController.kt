package com.kyukin.ontherock.interfaces.user;

import com.kyukin.ontherock.domain.user.service.UserService
import com.kyukin.ontherock.interfaces.user.dto.UserAuthRequest
import com.kyukin.ontherock.interfaces.user.dto.UserResponse
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
    fun login(@RequestBody @Valid request: UserAuthRequest.Login): UserResponse.Token {
        return userService.login(request);
    }
}