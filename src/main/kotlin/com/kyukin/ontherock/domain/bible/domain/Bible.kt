package com.kyukin.ontherock.domain.bible.domain

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "tbl_bible")
class Bible (

    @Column(length = 50, nullable = false)
    val cate: Int, // 구/신약 ( 1, 2 )

    @Column(length = 50, nullable = false)
    val book: Int, // 책 (숫자 1 ~ 66)

    @Column(length = 50, nullable = false)
    val chapter: Int, // 장

    @Column(nullable = false)
    val paragraph: Int, // 절

    @Column(length = 1000, nullable = false)
    val sentence: String, // 문장

    @Column(length = 1, nullable = false)
    val testament: Char, // 구/신약 ('구', '신')

    @Column(name = "long_label", length = 10, nullable = false)
    val longLabel: String, // 책 ("창세기", "출에굽기")

    @Column(name = "short_label", length = 5, nullable = false)
    val shortLabel: String, // 책 ("창", "출")

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bible_id", nullable = false, unique = true)
    val id: Long? = null,
)