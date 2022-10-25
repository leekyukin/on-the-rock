package com.kyukin.ontherock.domain.bible.exception

import com.kyukin.ontherock.global.error.exception.ErrorCode
import com.kyukin.ontherock.global.error.exception.OTRException

object NotAvailableWordException: OTRException(ErrorCode.NOT_AVAILABLE_WORD) {

    val EXCEPTION by lazy { this }
}
