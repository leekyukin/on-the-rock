package com.kyukin.ontherock.infrastructure.bible

import com.kyukin.ontherock.domain.bible.Bible
import com.kyukin.ontherock.domain.bible.designing.BibleReader
import com.kyukin.ontherock.domain.bible.type.LongLabel
import com.kyukin.ontherock.domain.bible.exception.BibleNotFoundException
import com.kyukin.ontherock.domain.bible.exception.NotAvailableWordException
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Component

@Component
class BibleReaderImpl(
    private val bibleRepository: BibleRepository,
): BibleReader {
    override fun findBiblePage(word: String, pageable: Pageable): Page<Bible> {
        validateWord(word)
        val biblePage = bibleRepository.findBySentenceContains(word, pageable)
        validateEmptyPage(biblePage)
        return biblePage
    }

    override fun findBiblePage(longLabel: LongLabel, chapter: Int, pageable: Pageable): Page<Bible> {
        val biblePage =  bibleRepository.findByLongLabelAndChapter(longLabel, chapter, pageable)
        validateEmptyPage(biblePage)
        return biblePage
    }

    override fun findBibleById(id: Long): Bible {
        return bibleRepository.findBibleById(id)
            ?: throw  BibleNotFoundException.EXCEPTION
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