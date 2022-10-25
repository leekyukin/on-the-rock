package com.jjarappappa.imom.global.security.jwt

import com.kyukin.ontherock.global.config.properties.JwtProperties
import com.kyukin.ontherock.global.security.jwt.exception.ExpiredTokenException
import com.kyukin.ontherock.global.security.jwt.exception.InvalidTokenException
import io.jsonwebtoken.Claims
import io.jsonwebtoken.ExpiredJwtException
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import io.jsonwebtoken.security.Keys
import org.springframework.stereotype.Component
import java.security.Key
import java.util.*
import javax.servlet.http.HttpServletRequest

@Component
class JwtProvider (
    val jwtProperties: JwtProperties,
) {

    fun createAccessToken(email: String): String {
        return createToken(email, jwtProperties.accessTokenValidTime)
    }

    private fun createToken(email: String, time: Long): String {
        val claims = Jwts.claims()
        claims["email"] = email
        val now = Date()

        return Jwts.builder()
            .setClaims(claims)
            .setIssuedAt(now)
            .setExpiration(Date(now.time + time))
            .signWith(getSigningKey(jwtProperties.secretKey), SignatureAlgorithm.HS256)
            .compact()
    }

    private fun getSigningKey(secretKey: String): Key {
        val keyBytes = secretKey.toByteArray(Charsets.UTF_8)
        return Keys.hmacShaKeyFor(keyBytes)
    }

    fun getEmail(token: String): String {
        return extractAllClaims(token)
            .get("email", String::class.java)
    }

    fun extractAllClaims(token: String): Claims {
        try {
            return Jwts.parserBuilder()
                .setSigningKey(getSigningKey(jwtProperties.secretKey))
                .build()
                .parseClaimsJws(token).body
        } catch (e: ExpiredJwtException) {
            throw ExpiredTokenException.EXCEPTION
        } catch (e: Exception) {
            throw InvalidTokenException.EXCEPTION
        }
    }

    fun resolveToken(request: HttpServletRequest): String? {
        val bearer = request.getHeader(jwtProperties.header)
        return parseToken(bearer)
    }

    private fun parseToken(bearer: String?): String? {
        if (bearer != null && bearer.startsWith(jwtProperties.prefix)) {
            return bearer.replace(jwtProperties.prefix, "")
        }

        return null
    }
}
