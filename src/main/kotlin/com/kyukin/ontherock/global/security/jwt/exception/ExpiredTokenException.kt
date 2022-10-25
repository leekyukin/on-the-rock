package com.kyukin.ontherock.global.security.jwt.exception

import com.kyukin.ontherock.global.error.exception.ErrorCode
import com.kyukin.ontherock.global.error.exception.IMomException

object ExpiredTokenException: IMomException(ErrorCode.EXPIRED_TOKEN) {
    val EXCEPTION by lazy { this }
}
