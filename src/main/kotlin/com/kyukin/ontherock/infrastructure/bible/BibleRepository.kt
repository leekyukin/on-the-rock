package com.kyukin.ontherock.infrastructure.bible

import com.kyukin.ontherock.domain.bible.Bible
import com.kyukin.ontherock.domain.bible.type.LongLabel
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository

interface BibleRepository: JpaRepository<Bible, Long>{
    fun findBibleById(id: Long): Bible?

    fun findBySentenceContains(word: String, pageable: Pageable): Page<Bible>

    fun findByLongLabelAndChapter(longLabel: LongLabel, chapter: Int, pageable: Pageable): Page<Bible>
}