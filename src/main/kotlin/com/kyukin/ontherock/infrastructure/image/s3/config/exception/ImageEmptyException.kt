package com.kyukin.ontherock.infrastructure.image.s3.exception

import com.kyukin.ontherock.global.error.exception.ErrorCode
import com.kyukin.ontherock.global.error.exception.IMomException

object ImageEmptyException: IMomException(ErrorCode.IMAGE_EMPTY) {
    val EXCEPTION by lazy { this }
}
