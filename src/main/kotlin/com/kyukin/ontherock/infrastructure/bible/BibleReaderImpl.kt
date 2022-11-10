package com.kyukin.ontherock.infrastructure.bible

import com.kyukin.ontherock.domain.bible.domain.Bible
import com.kyukin.ontherock.domain.bible.domain.designing.BibleReader
import com.kyukin.ontherock.domain.bible.domain.type.LongLabel
import com.kyukin.ontherock.domain.bible.exception.BibleNotFoundException
import com.kyukin.ontherock.domain.bible.exception.NotAvailableWordException
import com.kyukin.ontherock.interfaces.dto.res.BibleResponse
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Component

@Component
class BibleReaderImpl(
    private val bibleRepository: BibleRepository,
): BibleReader {

    override fun findBiblePage(word: String, pageable: Pageable): Page<BibleResponse> {
        validateWord(word)
        var result = bibleRepository.findBySentenceContains(word, pageable)
        validateEmptyPage(result)
        return result.map { BibleResponse.of(it) }
    }

    override fun findBiblePage(longLabel: LongLabel, chapter: Int, pageable: Pageable): Page<BibleResponse> {
        var result =  bibleRepository.findByLongLabelAndChapter(longLabel, chapter, pageable)
        validateEmptyPage(result)
        return result.map { BibleResponse.of(it) }
    }

    private fun validateEmptyPage(result: Page<Bible>) {
        if (result.isEmpty) {
            throw BibleNotFoundException.EXCEPTION
        }
    }

    private fun validateWord(word: String) {
        if (word.length == 1) {
            throw NotAvailableWordException.EXCEPTION
        }
    }
}