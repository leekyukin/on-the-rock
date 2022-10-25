package com.kyukin.ontherock.domain.image.service

import com.kyukin.ontherock.domain.image.controller.dto.ImageUrlResponse
import com.jjarappappa.imom.infrastructure.image.s3.facade.S3Facade
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.multipart.MultipartFile

@Service
class ImageService (
    val s3Facade: S3Facade,
) {

    @Transactional(readOnly = true)
    fun imgUpload(images: List<MultipartFile>): ImageUrlResponse {
        val image: List<String> = images
            .map { s3Facade.uploadImage(it) }
            .toList()

        return ImageUrlResponse(image)
    }
}
