package com.kyukin.ontherock.interfaces.dto

import com.kyukin.ontherock.domain.bible.type.LongLabel
import com.kyukin.ontherock.domain.bible.type.Testament

class BibleResponse {

    data class Main (
        val id: Long,
        val testament: Testament,
        val longLabel: LongLabel,
        val chapter: Int,
        val paragraph: Int,
        val sentence: String,
    )
}