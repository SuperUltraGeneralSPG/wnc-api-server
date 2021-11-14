package com.spg.wnc.api.advice

import com.spg.wnc.api.message.response.ErrorResponse
import com.spg.wnc.domain.common.ErrorCode
import com.spg.wnc.domain.common.SpgException
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestControllerAdvice
import javax.servlet.http.HttpServletResponse

@RestControllerAdvice
class ErrorControllerAdvice {
    private val logger = LoggerFactory.getLogger(this::class.java)

    @ExceptionHandler(Exception::class)
    @ResponseBody
    fun handleException(
        e: Exception,
        response: HttpServletResponse
    ) : ErrorResponse {
        logger.info("Unexpected Exception : ${e.message})")
        response.status = 500
        return ErrorResponse.from(ErrorCode.UNEXPECTED_ERROR)
    }

    @ExceptionHandler(SpgException::class)
    @ResponseBody
    fun handleSpgException(
        e: SpgException,
        response: HttpServletResponse
    ) : ErrorResponse {
        logger.info(e.message)
        response.status = 555
        return ErrorResponse.from(e.errorCode)
    }
}