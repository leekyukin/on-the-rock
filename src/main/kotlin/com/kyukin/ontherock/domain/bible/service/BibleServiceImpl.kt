package com.kyukin.ontherock.domain.bible.service

import com.kyukin.ontherock.domain.bible.domain.designing.BibleReader
import com.kyukin.ontherock.domain.bible.domain.type.LongLabel
import com.kyukin.ontherock.interfaces.dto.res.BibleResponse
import com.kyukin.ontherock.global.annotation.ServiceWithTransactionalReadOnly
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable

@ServiceWithTransactionalReadOnly
class BibleServiceImpl constructor(
    private val bibleReader: BibleReader,
): BibleService {

    override fun searchByWord(word: String, pageable: Pageable): Page<BibleResponse> {
        return bibleReader.findBiblePage(word, pageable)
    }

    override fun searchChapter(longLabel: LongLabel, chapter: Int, pageable: Pageable): Page<BibleResponse> {
        return bibleReader.findBiblePage(longLabel, chapter, pageable)
    }
}
