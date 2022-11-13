package com.kyukin.ontherock.domain.bible.service

import com.kyukin.ontherock.domain.bible.BibleCommand
import com.kyukin.ontherock.domain.bible.designing.BibleReader
import com.kyukin.ontherock.interfaces.dto.BibleResponse
import com.kyukin.ontherock.global.annotation.ServiceWithTransactionalReadOnly
import com.kyukin.ontherock.interfaces.dto.BibleDtoMapper
import org.mapstruct.factory.Mappers
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable

@ServiceWithTransactionalReadOnly
class BibleServiceImpl constructor(
    private val bibleReader: BibleReader,
): BibleService {
    private var bibleDtoMapper: BibleDtoMapper = Mappers.getMapper(BibleDtoMapper::class.java)

    override fun searchByWord(command: BibleCommand.SearchByWordRequest, pageable: Pageable): Page<BibleResponse> {
        val biblePage = bibleReader.findBiblePage(command.word, pageable)
        return biblePage.map { bibleDtoMapper.of(it) }
    }

    override fun searchChapter(command: BibleCommand.SearchByChapterRequest, pageable: Pageable): Page<BibleResponse> {
        val biblePage = bibleReader.findBiblePage(command.longLabel, command.chapter, pageable)
        return biblePage.map { bibleDtoMapper.of(it) }
    }

    override fun searchOneBible(id: Long): BibleResponse {
        val bible = bibleReader.findBibleById(id)
        return bibleDtoMapper.of(bible)
    }
}
