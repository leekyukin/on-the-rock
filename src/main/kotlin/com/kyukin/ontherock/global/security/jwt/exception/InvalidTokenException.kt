package com.kyukin.ontherock.global.security.jwt.exception

import com.kyukin.ontherock.global.error.exception.ErrorCode
import com.kyukin.ontherock.global.error.exception.OTRException

object InvalidTokenException: OTRException(ErrorCode.INVALID_TOKEN) {
    val EXCEPTION by lazy { this }
}