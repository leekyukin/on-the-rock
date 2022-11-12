package com.kyukin.ontherock.domain.bible.service

import com.kyukin.ontherock.domain.bible.designing.BibleReader
import com.kyukin.ontherock.domain.bible.type.LongLabel
import com.kyukin.ontherock.interfaces.dto.res.BibleResponse
import com.kyukin.ontherock.global.annotation.ServiceWithTransactionalReadOnly
import com.kyukin.ontherock.interfaces.dto.BibleDtoMapper
import org.mapstruct.factory.Mappers
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable

@ServiceWithTransactionalReadOnly
class BibleServiceImpl constructor(
    private val bibleReader: BibleReader,
): BibleService {
    private val bibleDtoMapper: BibleDtoMapper = Mappers.getMapper(BibleDtoMapper::class.java)

    override fun searchByWord(word: String, pageable: Pageable): Page<BibleResponse> {
        val biblePage = bibleReader.findBiblePage(word, pageable)
        return biblePage.map { bibleDtoMapper.of(it) }
    }

    override fun searchChapter(longLabel: LongLabel, chapter: Int, pageable: Pageable): Page<BibleResponse> {
        val biblePage = bibleReader.findBiblePage(longLabel, chapter, pageable)
        return biblePage.map { bibleDtoMapper.of(it) }
    }
}
