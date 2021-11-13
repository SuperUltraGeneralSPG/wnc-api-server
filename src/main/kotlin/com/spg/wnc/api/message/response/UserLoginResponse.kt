package com.spg.wnc.api.message.response

import com.spg.wnc.domain.model.user.UserType

data class UserLoginResponse(
    val userId: Long,
    val userType: UserType,
    val typeId: Long
)