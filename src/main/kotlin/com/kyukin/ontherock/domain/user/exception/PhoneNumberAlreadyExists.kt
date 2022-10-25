package com.kyukin.ontherock.domain.user.exception

import com.kyukin.ontherock.global.error.exception.ErrorCode
import com.kyukin.ontherock.global.error.exception.IMomException

object PhoneNumberAlreadyExists: IMomException(ErrorCode.PHONE_NUMBER_ALREADY_EXISTS) {
    val EXCEPTION by lazy { this }
}
