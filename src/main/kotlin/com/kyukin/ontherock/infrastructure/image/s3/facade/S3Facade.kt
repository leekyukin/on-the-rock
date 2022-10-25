package com.jjarappappa.imom.infrastructure.image.s3.facade

import com.amazonaws.services.s3.AmazonS3Client
import com.amazonaws.services.s3.model.CannedAccessControlList
import com.amazonaws.services.s3.model.ObjectMetadata
import com.amazonaws.services.s3.model.PutObjectRequest
import com.kyukin.ontherock.infrastructure.image.ImageUtil
import com.kyukin.ontherock.infrastructure.image.s3.S3Properties
import com.kyukin.ontherock.infrastructure.image.s3.exception.ImageEmptyException
import com.kyukin.ontherock.infrastructure.image.s3.exception.UploadImageFailedException
import org.springframework.stereotype.Component
import org.springframework.web.multipart.MultipartFile
import java.util.*

@Component
class S3Facade constructor(
    val s3Properties: S3Properties,
    val amazonS3Client: AmazonS3Client,
): ImageUtil {

        override fun uploadImage(image: MultipartFile): String {

            if (image.isEmpty) {
                throw ImageEmptyException.EXCEPTION
            }

            val fileName:String = s3Properties.bucket + "/" + UUID.randomUUID() + image.originalFilename

            try {

                val putObjectRequest = PutObjectRequest(
                    s3Properties.bucket,
                    fileName,
                    image.inputStream,
                    getObjectMetadata(image),
                )

                amazonS3Client.putObject(putObjectRequest.withCannedAcl(CannedAccessControlList.PublicRead))

            } catch (e: Exception) {
                throw UploadImageFailedException.EXCEPTION
            }

            return getFileName(fileName)
    }


    private fun getObjectMetadata(image: MultipartFile): ObjectMetadata {
        val data = ObjectMetadata()
        data.contentLength = image.size
        data.contentType = image.contentType
        return data
    }

    private fun getFileName(fileName: String): String {
        return amazonS3Client.getUrl(s3Properties.bucket, fileName).toString()
    }
}