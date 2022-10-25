package com.kyukin.ontherock.global.error.exception

import com.kyukin.ontherock.global.error.exception.ErrorCode

open class IMomException (
    val errorCode: ErrorCode,
    message: String,
): RuntimeException(message) {
    constructor(errorCode: ErrorCode): this(errorCode, errorCode.message)
}