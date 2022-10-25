package com.kyukin.ontherock.domain.bible.service

import com.kyukin.ontherock.domain.bible.domain.repository.BibleRepository
import com.kyukin.ontherock.domain.bible.exception.BibleNotFoundException
import com.kyukin.ontherock.domain.bible.facade.BibleFacade
import com.kyukin.ontherock.domain.bible.presentation.dto.res.BibleResponse
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class BibleService constructor(
    private val bibleRepository: BibleRepository,
    private val bibleFacade: BibleFacade,
){

    @Transactional(readOnly = true)
    fun searchByWord(word: String): List<BibleResponse> {

        bibleFacade.validateWord(word)

        val results = bibleRepository.findBySentenceContains(word)
            .map { it -> BibleResponse.of(it) }
            .toList()

        bibleFacade.validateListSize(results)

        return results
    }
}
