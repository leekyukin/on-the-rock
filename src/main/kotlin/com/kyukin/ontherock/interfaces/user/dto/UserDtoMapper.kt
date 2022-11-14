package com.kyukin.ontherock.interfaces.user.dto

import com.kyukin.ontherock.domain.user.User
import com.kyukin.ontherock.domain.user.UserCommand
import org.mapstruct.InjectionStrategy
import org.mapstruct.Mapper
import org.mapstruct.ReportingPolicy

@Mapper(
    componentModel = "spring",
    injectionStrategy = InjectionStrategy.CONSTRUCTOR,
    unmappedTargetPolicy = ReportingPolicy.ERROR
)
interface UserDtoMapper {

    fun of(request: UserAuthRequest.Join): UserCommand.Join

    fun of(user: User): UserResponse.Profile
}