package com.kyukin.ontherock.domain.bible.presentation

import com.kyukin.ontherock.domain.bible.presentation.dto.res.BibleResponse
import com.kyukin.ontherock.domain.bible.service.BibleService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/bible")
class BibleController constructor(
    private val bibleService: BibleService,
) {

    @GetMapping
    fun searchByWord(
        @RequestParam(name = "word") word: String,
        pageable: Pageable,
    ): Page<BibleResponse> {
        return bibleService.searchByWord(word, pageable);
    }
}