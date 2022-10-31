package com.kyukin.ontherock.domain.bible.service

import com.kyukin.ontherock.domain.bible.domain.repository.BibleRepository
import com.kyukin.ontherock.domain.bible.domain.type.LongLabel
import com.kyukin.ontherock.domain.bible.exception.BibleNotFoundException
import com.kyukin.ontherock.domain.bible.facade.BibleFacade
import com.kyukin.ontherock.domain.bible.presentation.dto.res.BibleResponse
import com.kyukin.ontherock.global.annotation.ServiceWithTransactionalReadOnly
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable

@ServiceWithTransactionalReadOnly
class BibleService constructor(
    private val bibleRepository: BibleRepository,
    private val bibleFacade: BibleFacade,
){

    fun searchByWord(word: String, pageable: Pageable): Page<BibleResponse> {

        bibleFacade.validateWord(word)

        val results = bibleRepository.findBySentenceContains(word, pageable)
            .map(BibleResponse::of)

        bibleFacade.validateEmptyPage(results)

        return results
    }

    fun searchChapter(longLabel: LongLabel, chapter: Int, pageable: Pageable): Page<BibleResponse> {
        return bibleRepository.findByLongLabelAndChapter(longLabel, chapter, pageable)
            .map { it?: throw BibleNotFoundException.EXCEPTION }
            .map { BibleResponse.of(it) }
    }
}
