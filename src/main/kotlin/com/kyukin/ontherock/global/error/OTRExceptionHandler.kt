package com.kyukin.ontherock.global.error

import com.kyukin.ontherock.global.error.exception.ErrorCode
import com.kyukin.ontherock.global.error.exception.OTRException
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice
import javax.servlet.http.HttpServletRequest

@RestControllerAdvice
class OTRExceptionHandler {

    private val log = LoggerFactory.getLogger(javaClass)

    @ResponseStatus(value = HttpStatus.CONFLICT)
    @ExceptionHandler(OTRException::class)
    fun handleIceCreamException(
        e: OTRException,
        request: HttpServletRequest
    ): ErrorResponse {
        log.error("errorCode: {}, url: {}, message: {}",
            e.errorCode, request.requestURI, e.message)

        return ErrorResponse(e.errorCode);
    }

    @ExceptionHandler(Exception::class)
    fun handleRuntimeException(
        e: Exception,
        request: HttpServletRequest,
    ): ErrorResponse {
        log.error("url: {}, message: {}", request.requestURI, e.message)

        return ErrorResponse(ErrorCode.INTERNAL_SERVER_ERROR)
    }

}