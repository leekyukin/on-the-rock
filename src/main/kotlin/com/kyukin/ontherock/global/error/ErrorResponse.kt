package com.kyukin.ontherock.global.error

import com.kyukin.ontherock.global.error.exception.ErrorCode

class ErrorResponse(
    val status: Int,
    val message: String,
) {
    constructor(errorCode: ErrorCode): this(errorCode.status, errorCode.message)
}