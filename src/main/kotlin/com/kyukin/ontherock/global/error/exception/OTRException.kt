package com.kyukin.ontherock.global.error.exception

open class OTRException (
    val errorCode: ErrorCode,
    message: String,
): RuntimeException(message) {
    constructor(errorCode: ErrorCode): this(errorCode, errorCode.message)
}