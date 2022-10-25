package com.kyukin.ontherock.domain.user.domain.repository

import com.kyukin.ontherock.domain.user.domain.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository: JpaRepository<User, Long> {

    fun existsByNickname(nickName: String): Boolean;

    fun existsByEmail(email: String): Boolean;

    fun existsByPhoneNumber(phoneNumber: String): Boolean;

    fun findByEmail(email: String): User?
}