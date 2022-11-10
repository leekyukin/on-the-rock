package com.kyukin.ontherock.domain.bible.domain.designing

import com.kyukin.ontherock.domain.bible.domain.type.LongLabel
import com.kyukin.ontherock.interfaces.dto.res.BibleResponse
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable

interface BibleReader {
    fun findBiblePage(word: String, pageable: Pageable): Page<BibleResponse>

    fun findBiblePage(longLabel: LongLabel, chapter: Int, pageable: Pageable): Page<BibleResponse>
}