package com.kyukin.ontherock.global.security.auth

import com.kyukin.ontherock.domain.user.facade.UserFacade
import com.kyukin.ontherock.global.security.auth.AuthDetails
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

@Service
class AuthDetailsService (
    val userFacade: UserFacade,
): UserDetailsService {

    override fun loadUserByUsername(username: String): UserDetails {
         return AuthDetails(userFacade.findUserByEmail(username))
    }
}