package com.kyukin.ontherock.infrastructure.bible

import com.kyukin.ontherock.domain.bible.domain.Bible
import com.kyukin.ontherock.domain.bible.domain.designing.BibleReader
import com.kyukin.ontherock.domain.bible.domain.type.LongLabel
import com.kyukin.ontherock.domain.bible.exception.BibleNotFoundException
import com.kyukin.ontherock.domain.bible.exception.NotAvailableWordException
import com.kyukin.ontherock.interfaces.dto.BibleDtoMapper
import com.kyukin.ontherock.interfaces.dto.BibleDtoMapperImpl
import com.kyukin.ontherock.interfaces.dto.res.BibleResponse
import org.mapstruct.factory.Mappers
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Component

@Component
class BibleReaderImpl(
    private val bibleRepository: BibleRepository,
): BibleReader {
    private val bibleDtoMapper: BibleDtoMapper = Mappers.getMapper(BibleDtoMapper::class.java)

    override fun findBiblePage(word: String, pageable: Pageable): Page<BibleResponse> {
        validateWord(word)
        val result = bibleRepository.findBySentenceContains(word, pageable)
        validateEmptyPage(result)
        return result.map { bibleDtoMapper.of(it) }
    }

    override fun findBiblePage(longLabel: LongLabel, chapter: Int, pageable: Pageable): Page<BibleResponse> {
        val result =  bibleRepository.findByLongLabelAndChapter(longLabel, chapter, pageable)
        validateEmptyPage(result)
        return result.map { bibleDtoMapper.of(it) }
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