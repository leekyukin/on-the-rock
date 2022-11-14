package com.kyukin.ontherock.domain.bible

import com.kyukin.ontherock.domain.bible.type.LongLabel

class BibleCommand {

    class SearchByIdRequest(
        val id: Long,
    )

    class SearchByWordRequest(
        val word: String,
    )

    class SearchByChapterRequest(
        val longLabel: LongLabel,
        val chapter: Int,
    )
}