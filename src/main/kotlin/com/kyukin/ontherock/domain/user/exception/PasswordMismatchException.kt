package com.kyukin.ontherock.domain.user.exception

import com.kyukin.ontherock.global.error.exception.ErrorCode
import com.kyukin.ontherock.global.error.exception.IMomException

object PasswordMismatchException: IMomException(ErrorCode.PASSWORD_MISMATCH) {
    val EXCEPTION by lazy { this }
}
