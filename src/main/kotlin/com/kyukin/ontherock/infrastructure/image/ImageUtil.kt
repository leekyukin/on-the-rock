package com.kyukin.ontherock.infrastructure.image

import org.springframework.web.multipart.MultipartFile

interface ImageUtil {
    fun uploadImage(image: MultipartFile): String
}