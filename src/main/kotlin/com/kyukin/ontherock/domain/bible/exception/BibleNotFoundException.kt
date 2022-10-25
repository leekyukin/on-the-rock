package com.kyukin.ontherock.domain.bible.exception

import com.kyukin.ontherock.global.error.exception.ErrorCode
import com.kyukin.ontherock.global.error.exception.OTRException

object BibleNotFoundException: OTRException(ErrorCode.BIBLE_NOT_FOUND) {
    val EXCEPTION by lazy { this }
}
