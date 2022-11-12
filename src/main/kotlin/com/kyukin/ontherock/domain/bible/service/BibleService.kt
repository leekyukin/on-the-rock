package com.kyukin.ontherock.domain.bible.service

import com.kyukin.ontherock.domain.bible.type.LongLabel
import com.kyukin.ontherock.interfaces.dto.res.BibleResponse
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable

interface BibleService {
    fun searchByWord(word: String, pageable: Pageable): Page<BibleResponse>

    fun searchChapter(longLabel: LongLabel, chapter: Int, pageable: Pageable): Page<BibleResponse>
}