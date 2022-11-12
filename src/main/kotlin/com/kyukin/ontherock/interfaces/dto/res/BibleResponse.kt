package com.kyukin.ontherock.interfaces.dto.res

import com.kyukin.ontherock.domain.bible.type.LongLabel
import com.kyukin.ontherock.domain.bible.type.Testament

data class BibleResponse constructor(

    val testament: Testament,

    val longLabel: LongLabel,

    val chapter: Int,

    val paragraph: Int,

    val sentence: String,
)
