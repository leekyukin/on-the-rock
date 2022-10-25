package com.kyukin.ontherock.domain.user.exception

import com.kyukin.ontherock.global.error.exception.ErrorCode
import com.kyukin.ontherock.global.error.exception.IMomException

object UserNotFoundException: IMomException(ErrorCode.USER_NOT_FOUND) {
    val EXCEPTION by lazy { this }
}
