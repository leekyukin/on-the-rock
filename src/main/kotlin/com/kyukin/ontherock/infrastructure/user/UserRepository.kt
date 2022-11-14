package com.kyukin.ontherock.infrastructure.user

import com.kyukin.ontherock.domain.user.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository: JpaRepository<User, Long> {

    fun existsByNickname(nickName: String): Boolean;

    fun existsByEmail(email: String): Boolean;

    fun existsByPhoneNumber(phoneNumber: String): Boolean;

    fun findByEmail(email: String): User?
}