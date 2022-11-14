package com.kyukin.ontherock.domain.user.service.mybible


interface MyBibleService {
    fun addBible(id: Long)
    fun removeBible(id: Long)
    fun getMyBible()
}