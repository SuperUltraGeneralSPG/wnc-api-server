package com.spg.wnc.api.message.request

import com.spg.wnc.domain.model.user.UserType

data class UserInfoModifyRequest(
    val userId: Long,
    val loginId: String,
    val password: String,
    val userType: UserType,
    val career: List<String>?
)