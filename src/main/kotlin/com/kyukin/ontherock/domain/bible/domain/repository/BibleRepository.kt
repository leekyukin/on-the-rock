package com.kyukin.ontherock.domain.bible.domain.repository

import com.kyukin.ontherock.domain.bible.domain.Bible
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository

interface BibleRepository: JpaRepository<Bible, Long>{

    fun findBySentenceContains(word: String, pageable: Pageable): Page<Bible>

    fun findByLongLabelAndChapter(longLabel: LongLabel, chapter: Int, pageable: Pageable): Page<Bible>
}