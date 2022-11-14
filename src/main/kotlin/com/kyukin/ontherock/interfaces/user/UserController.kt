package com.kyukin.ontherock.interfaces.user

import com.kyukin.ontherock.domain.user.service.UserService
import com.kyukin.ontherock.interfaces.user.dto.UserAuthRequest
import com.kyukin.ontherock.interfaces.user.dto.UserDtoMapper
import com.kyukin.ontherock.interfaces.user.dto.UserResponse
import org.mapstruct.factory.Mappers
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/user")
class UserController constructor(
    private val userService: UserService,
){
    private val userDtoMapper = Mappers.getMapper(UserDtoMapper::class.java)

    @PostMapping
    fun joinUser(@RequestBody @Valid request: UserAuthRequest.Join) {
        val userCommand = userDtoMapper.of(request)
        userService.createUser(userCommand);
    }

    @GetMapping
    fun getProfile(): UserResponse.Profile {
        return userService.getProfile();
    }

    @PutMapping("/profileImg")
    fun updateProfileImage(@RequestParam("img") img: String) {
        userService.updateProfileImage(img);
    }
}