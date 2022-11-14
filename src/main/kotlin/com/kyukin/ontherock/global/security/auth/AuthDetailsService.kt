package com.kyukin.ontherock.global.security.auth

import com.kyukin.ontherock.domain.user.design.UserReader
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

@Service
class AuthDetailsService (
    private val userReader: UserReader,
): UserDetailsService {

    override fun loadUserByUsername(username: String): UserDetails {
         return AuthDetails(userReader.findUserByEmail(username))
    }
}