package com.kyukin.ontherock.interfaces.bible.dto

import com.kyukin.ontherock.domain.bible.type.LongLabel

class BibleSearchRequest {

    data class SearchByChapterRequest constructor(
        var longLabel: LongLabel,
        var chapter: Int,
    )

    data class SearchByIdRequest constructor(
        var id: Long,
    )

    data class SearchByWordRequest constructor(
        var word: String,
    )
}