package com.spg.wnc.api.message.response

import com.spg.wnc.domain.common.ResultResponseCode
import com.spg.wnc.domain.model.user.User
import com.spg.wnc.domain.model.user.UserType

data class UserLoginResponse(
    val responseCode: ResultResponseCode,
    val userId: Long?,
    val userType: UserType?
) {
    companion object {
        fun from(user: User) = UserLoginResponse(
            responseCode = ResultResponseCode.SUCCESS,
            userId = user.id,
            userType = user.userType
        )

        fun fail() = UserLoginResponse(
            responseCode = ResultResponseCode.FAIL,
            userId = null,
            userType = null
        )
    }
}