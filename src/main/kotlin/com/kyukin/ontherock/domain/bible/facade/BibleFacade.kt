package com.kyukin.ontherock.domain.bible.facade

import com.kyukin.ontherock.domain.bible.domain.repository.BibleRepository
import com.kyukin.ontherock.domain.bible.exception.BibleNotFoundException
import com.kyukin.ontherock.domain.bible.exception.NotAvailableWordException
import com.kyukin.ontherock.domain.bible.presentation.dto.res.BibleResponse
import org.springframework.data.domain.Page
import org.springframework.stereotype.Component

@Component
class BibleFacade constructor(
    private val bibleRepository: BibleRepository,
) {

    fun validateWord(word: String) {
        if (word.length == 1) {
            throw NotAvailableWordException.EXCEPTION
        }
    }

    fun validateEmptyPage(results: Page<BibleResponse>) {
        if (results.isEmpty) {
            throw BibleNotFoundException.EXCEPTION
        }
    }
}
