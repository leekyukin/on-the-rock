package com.kyukin.ontherock.global.security

import com.kyukin.ontherock.global.security.auth.AuthDetailsService
import com.jjarappappa.imom.global.security.jwt.JwtProvider
import com.kyukin.ontherock.global.security.jwt.filter.JwtAuthenticationFilter
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter

@Configuration
@EnableWebSecurity
class SecurityConfig (
    private val authDetailsService: AuthDetailsService,
    private val jwtProvider: JwtProvider
){

    @Bean
    fun passwordEncoder(): PasswordEncoder {
        return BCryptPasswordEncoder()
    }

    @Bean
    @Throws(Exception::class)
    fun filterChain(http: HttpSecurity): SecurityFilterChain? {
        http
            .httpBasic().disable()
            .formLogin().disable()
            .csrf().disable()
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)

            .and()
            .authorizeRequests()
            .anyRequest().permitAll()

            http
                .addFilterBefore(JwtAuthenticationFilter(authDetailsService, jwtProvider), UsernamePasswordAuthenticationFilter::class.java)

        return http.build()
    }
}