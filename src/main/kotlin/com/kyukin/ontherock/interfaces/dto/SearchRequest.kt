package com.kyukin.ontherock.interfaces.dto

import com.kyukin.ontherock.domain.bible.type.LongLabel

class SearchRequest {

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