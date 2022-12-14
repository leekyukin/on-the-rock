package com.kyukin.ontherock.domain.bible.service

import com.kyukin.ontherock.domain.bible.BibleCommand
import com.kyukin.ontherock.interfaces.bible.dto.BibleResponse
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable

interface BibleService {
    fun searchByWord(command: BibleCommand.SearchByWordRequest, pageable: Pageable): Page<BibleResponse.Main>

    fun searchChapter(command: BibleCommand.SearchByChapterRequest, pageable: Pageable): Page<BibleResponse.Main>

    fun searchOneBible(id: Long): BibleResponse.Main
}