package com.kyukin.ontherock.interfaces.user

import com.kyukin.ontherock.domain.user.service.UserService
import com.kyukin.ontherock.interfaces.user.dto.UserDtoMapper
import com.kyukin.ontherock.interfaces.user.dto.UserRequest
import com.kyukin.ontherock.interfaces.user.dto.UserResponse
import org.mapstruct.factory.Mappers
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/user")
class UserApiController constructor(
    private val userService: UserService,
) {
    private val userDtoMapper = Mappers.getMapper(UserDtoMapper::class.java)

    @GetMapping
    fun getProfile(): UserResponse.Profile {
        return userService.getProfile();
    }

    @PutMapping("/profileImg")
    fun updateProfileImage(@RequestBody @Validated request: UserRequest.UpdateProfileImg) {
        val userCommand = userDtoMapper.of(request)
        userService.updateProfileImage(userCommand);
    }
}