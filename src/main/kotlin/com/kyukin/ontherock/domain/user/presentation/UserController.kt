package com.kyukin.ontherock.domain.user.presentation

import com.kyukin.ontherock.domain.user.presentation.dto.request.UserJoinRequest
import com.kyukin.ontherock.domain.user.presentation.dto.response.UserProfileResponse
import com.kyukin.ontherock.domain.user.service.UserService
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/user")
class UserController constructor(
    private val userService: UserService,
){

    @PostMapping
    fun joinUser(@RequestBody @Valid request: UserJoinRequest) {
        userService.createUser(request);
    }

    @GetMapping
    fun getProfile(): UserProfileResponse {
        return userService.getProfile();
    }

    @PutMapping("/profileImg")
    fun updateProfileImage(@RequestParam("img") img: String) {
        userService.updateProfileImage(img);
    }
}