package com.kyukin.ontherock.global.error.exception

enum class ErrorCode (
    val status: Int,
    val message: String,
){
    INTERNAL_SERVER_ERROR(500, "서버에 오류가 발생했습니다."),
    BAD_REQUEST(404, "잘못된 요청입니다."),

    EXPIRED_TOKEN(401, "토큰이 만료되었습니다."),
    INVALID_TOKEN(401, "유효하지 않은 토큰입니다."),

    NICKNAME_ALREADY_EXISTS(422, "이미 존재하는 닉네임입니다."),
    EMAIL_ALREADY_EXISTS(422, "이미 존재하는 이메일입니다."),
    PHONE_NUMBER_ALREADY_EXISTS(422, "이미 존재하는 전화번호입니다."),
    USER_NOT_FOUND( 404, "존재하지 않는 유저입니다."),
    PASSWORD_MISMATCH( 401, "비밀번호가 틀렸습니다."),

    IMAGE_EMPTY(422, "이미지가 비었습니다."),
    UPLOAD_IMAGE_FAILED(422, "이미지 업로드에 실패했습니다."),

    BIBLE_NOT_FOUND( 422, "검색결과를 찾을 수 없습니다."),
    NOT_AVAILABLE_WORD( 404, "옳지 않은 검색어입니다."),
}