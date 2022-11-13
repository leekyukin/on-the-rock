package com.kyukin.ontherock.interfaces

import com.kyukin.ontherock.domain.bible.service.BibleService
import com.kyukin.ontherock.interfaces.dto.BibleDtoMapper
import com.kyukin.ontherock.interfaces.dto.BibleResponse
import com.kyukin.ontherock.interfaces.dto.SearchRequest.*
import org.mapstruct.factory.Mappers
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/bible")
class BibleApiController constructor(
    private val bibleService: BibleService,
) {
    private var bibleDtoMapper = Mappers.getMapper(BibleDtoMapper::class.java)

    @GetMapping("/word")
    fun searchByWord(
        @RequestBody request: SearchByWordRequest,
        @PageableDefault(size = 10) pageable: Pageable,
    ): Page<BibleResponse> {
        val bibleCommand = bibleDtoMapper.of(request)
        return bibleService.searchByWord(bibleCommand, pageable)
    }

    @GetMapping("/chapter")
    fun searchChapter(
        @RequestBody request: SearchByChapterRequest,
        @PageableDefault(size = 10) pageable: Pageable,
    ): Page<BibleResponse> {
        val bibleCommand = bibleDtoMapper.of(request)
        return bibleService.searchChapter(bibleCommand, pageable)
    }

    @GetMapping("/{id}")
    fun searchOneBible(@PathVariable id: Long): BibleResponse {
        return bibleService.searchOneBible(id)
    }
}