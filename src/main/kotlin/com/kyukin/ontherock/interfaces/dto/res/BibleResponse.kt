package com.kyukin.ontherock.interfaces.dto.res

import com.kyukin.ontherock.domain.bible.domain.Bible
import com.kyukin.ontherock.domain.bible.domain.type.LongLabel
import com.kyukin.ontherock.domain.bible.domain.type.Testament

data class BibleResponse constructor(

    val testament: Testament,

    val longLabel: LongLabel,

    val chapter: Int,

    val paragraph: Int,

    val sentence: String,
) {

    companion object {
        fun of(bible:Bible): BibleResponse {
            return BibleResponse(
                bible.testament,
                bible.longLabel,
                bible.chapter,
                bible.paragraph,
                bible.sentence,
            )
        }
    }
}
