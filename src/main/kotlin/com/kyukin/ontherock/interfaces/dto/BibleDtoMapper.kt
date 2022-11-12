package com.kyukin.ontherock.interfaces.dto

import com.kyukin.ontherock.domain.bible.Bible
import com.kyukin.ontherock.interfaces.dto.res.BibleResponse
import org.mapstruct.InjectionStrategy
import org.mapstruct.Mapper
import org.mapstruct.ReportingPolicy

@Mapper(
    componentModel = "spring",
    injectionStrategy = InjectionStrategy.CONSTRUCTOR,
    unmappedTargetPolicy = ReportingPolicy.ERROR
)
interface BibleDtoMapper {
    fun of(bible: Bible): BibleResponse
}