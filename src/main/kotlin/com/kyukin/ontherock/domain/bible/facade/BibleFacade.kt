package com.kyukin.ontherock.domain.bible.facade

import com.kyukin.ontherock.domain.bible.Bible
import com.kyukin.ontherock.infrastructure.bible.BibleRepository
import com.kyukin.ontherock.domain.bible.exception.BibleNotFoundException
import org.springframework.stereotype.Component

@Component
class BibleFacade constructor(
    private val bibleRepository: BibleRepository,
) {
    fun findBibleById(id: Long): Bible {
        return bibleRepository.findBibleById(id)
            ?: throw BibleNotFoundException.EXCEPTION
    }
}
