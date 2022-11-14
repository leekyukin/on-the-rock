package com.kyukin.ontherock.domain.user.design

import com.kyukin.ontherock.domain.user.User

interface UserReader {

    fun findUserByEmail(email: String): User

    fun getCurrentUser(): User
}