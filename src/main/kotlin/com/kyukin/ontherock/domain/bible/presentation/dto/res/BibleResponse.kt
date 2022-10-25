package com.kyukin.ontherock.domain.bible.presentation.dto.res

import com.kyukin.ontherock.domain.bible.domain.Bible

data class BibleResponse constructor(

    val testament: Char,

    val longLabel: String,

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
