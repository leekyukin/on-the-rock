package com.kyukin.ontherock.infrastructure.image.s3.exception

import com.kyukin.ontherock.global.error.exception.ErrorCode
import com.kyukin.ontherock.global.error.exception.OTRException

object UploadImageFailedException: OTRException(ErrorCode.UPLOAD_IMAGE_FAILED) {
    val EXCEPTION by lazy { this }
}
