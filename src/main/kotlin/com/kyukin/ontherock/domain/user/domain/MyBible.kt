//package com.kyukin.ontherock.domain.user.domain
//
//import com.kyukin.ontherock.domain.bible.Bible
//import com.kyukin.ontherock.global.entity.BaseTimeEntity
//import javax.persistence.*
//
//@Entity
//@Table(name = "tbl_my_bible")
//class MyBible constructor(
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "user_id")
//    val user: User,
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "bible_id")
//    val bible: Bible,
//
//    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "my_bible_id")
//    val myBibleId: Long? = null,
//) : BaseTimeEntity() {
//
//    companion object {
//        fun createMyBible(user: User, bible: Bible): Bible {
//            return createMyBible(user, bible)
//        }
//    }
//}