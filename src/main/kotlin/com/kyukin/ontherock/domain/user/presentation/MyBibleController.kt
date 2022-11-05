package com.kyukin.ontherock.domain.user.presentation

import com.kyukin.ontherock.domain.user.service.MyBibleService
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/my-bible/{id}")
class MyBibleController constructor(
    private val myBibleService: MyBibleService,
){

    @PostMapping
    fun addMyBible(@PathVariable id: Long) {
        myBibleService.addMyBible(id);
    }

}