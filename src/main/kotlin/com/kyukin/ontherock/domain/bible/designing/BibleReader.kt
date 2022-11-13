package com.kyukin.ontherock.domain.bible.designing

import com.kyukin.ontherock.domain.bible.Bible
import com.kyukin.ontherock.domain.bible.type.LongLabel
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable

interface BibleReader {
    fun findBiblePage(word: String, pageable: Pageable): Page<Bible>

    fun findBiblePage(longLabel: LongLabel, chapter: Int, pageable: Pageable): Page<Bible>

    fun findBibleById(id: Long): Bible
}