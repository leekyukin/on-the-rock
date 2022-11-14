package com.kyukin.ontherock.domain.user.design

import com.kyukin.ontherock.domain.user.User

interface UserStore {
    fun registerUser(user: User)
}