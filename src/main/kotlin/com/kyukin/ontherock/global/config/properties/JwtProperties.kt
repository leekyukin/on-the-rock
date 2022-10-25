package com.kyukin.ontherock.global.config.properties

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConfigurationPropertiesBinding
import org.springframework.boot.context.properties.ConstructorBinding
import org.springframework.context.annotation.Configuration

@ConstructorBinding
@ConfigurationProperties("jwt")
data class JwtProperties (
    val accessTokenValidTime: Long,
    val prefix: String,
    val header: String,
    val secretKey: String,
)