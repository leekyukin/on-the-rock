package com.kyukin.ontherock.global.security.jwt.filter

import com.kyukin.ontherock.global.security.auth.AuthDetailsService
import com.kyukin.ontherock.global.security.jwt.JwtProvider
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource
import org.springframework.web.filter.OncePerRequestFilter
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class JwtAuthenticationFilter (
    private val authDetailsService: AuthDetailsService,
    private val jwtProvider: JwtProvider,
): OncePerRequestFilter() {

    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {
        val accessToken = jwtProvider.resolveToken(request)
        if (accessToken != null) {
            setAuthentication(accessToken, request)
        }

        filterChain.doFilter(request, response)
    }

    private fun setAuthentication(token: String, request: HttpServletRequest) {
        val userDetails = authDetailsService.loadUserByUsername(jwtProvider.getEmail(token))
        val authentication = UsernamePasswordAuthenticationToken(userDetails, null, userDetails.authorities)
        authentication.details = WebAuthenticationDetailsSource().buildDetails(request)
        SecurityContextHolder.getContext().authentication = authentication
    }
}