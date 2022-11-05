package com.kyukin.ontherock.domain.user.domain.repository

import com.kyukin.ontherock.domain.user.domain.MyBible
import org.springframework.data.jpa.repository.JpaRepository

interface MyBibleRepository: JpaRepository<MyBible, Long> {

}
