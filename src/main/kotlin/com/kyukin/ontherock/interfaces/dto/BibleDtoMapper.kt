package com.kyukin.ontherock.interfaces.dto

import com.kyukin.ontherock.domain.bible.Bible
import com.kyukin.ontherock.domain.bible.BibleCommand
import com.kyukin.ontherock.interfaces.dto.SearchRequest.*
import org.mapstruct.InjectionStrategy
import org.mapstruct.Mapper
import org.mapstruct.ReportingPolicy

@Mapper(
    componentModel = "spring",
    injectionStrategy = InjectionStrategy.CONSTRUCTOR,
    unmappedTargetPolicy = ReportingPolicy.ERROR
)
interface BibleDtoMapper {
    fun of(bible: Bible): BibleResponse.Main

    fun of(request: SearchByWordRequest): BibleCommand.SearchByWordRequest

    fun of(request: SearchByChapterRequest): BibleCommand.SearchByChapterRequest

    fun of(request: SearchByIdRequest): BibleCommand.SearchByIdRequest
}