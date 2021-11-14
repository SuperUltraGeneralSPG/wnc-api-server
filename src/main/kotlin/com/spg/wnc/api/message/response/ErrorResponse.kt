package com.spg.wnc.api.message.response

import com.spg.wnc.domain.common.ErrorCode

data class ErrorResponse(
    val errorCode: String,
    val errorMessage: String
) {
    companion object {
        fun from(errorCode: ErrorCode): ErrorResponse {
            return ErrorResponse(errorCode.name, errorCode.message)
        }
    }
}