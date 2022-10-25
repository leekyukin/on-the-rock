package com.kyukin.ontherock.domain.bible.domain.repository

import com.kyukin.ontherock.domain.bible.domain.Bible
import org.springframework.data.jpa.repository.JpaRepository

interface BibleRepository: JpaRepository<Bible, Long>{

    fun findBySentenceContains(word: String): List<Bible>;
}