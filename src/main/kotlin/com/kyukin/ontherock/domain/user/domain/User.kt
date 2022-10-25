package com.kyukin.ontherock.domain.user.domain

import com.kyukin.ontherock.domain.user.domain.type.Authority
import com.kyukin.ontherock.global.entity.BaseTimeEntity
import javax.persistence.*

@Entity
@Table(name = "tbl_user")
class User (
        @Column(length = 50, nullable = false)
        val name: String,

        @Column(length = 15, nullable = false, unique = true)
        var nickname: String,

        @Column(length = 50, nullable = false, unique = true)
        val email: String,

        @Column(nullable = false)
        var password: String,

        @Enumerated(EnumType.STRING)
        @Column(length = 10, nullable = false)
        var authority: Authority,

        @Column(length = 50, nullable = false)
        var birthday: String,

        @Column(length = 15, nullable = false, unique = true)
        var phoneNumber: String,

        @Column(length = 70, nullable = false, unique = true)
        var address: String,

        @Column(nullable = false)
        var profileImg: String,

        @Column(nullable = false, unique = true)
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long? = null,
): BaseTimeEntity() {

    fun updateProfileImage(profileImg: String) {
            this.profileImg = profileImg
    }
}