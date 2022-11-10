package com.kyukin.ontherock.domain.user.service

import com.kyukin.ontherock.domain.bible.facade.BibleFacade
import com.kyukin.ontherock.domain.user.domain.MyBible
import com.kyukin.ontherock.domain.user.domain.repository.MyBibleRepository
import com.kyukin.ontherock.domain.user.facade.UserFacade
import org.springframework.stereotype.Service

@Service
class MyBibleService constructor(
    private val myBibleRepository: MyBibleRepository,
    private val bibleFacade: BibleFacade,
    private val userFacade: UserFacade,
) {

    fun addMyBible(id: Long) {
        var user = userFacade.getCurrentUser()
        var bible = bibleFacade.findBibleById(id)
        var myBible = MyBible.createMyBible(user, bible);

//        user.myBibleList.add(myBible);
    }

}
