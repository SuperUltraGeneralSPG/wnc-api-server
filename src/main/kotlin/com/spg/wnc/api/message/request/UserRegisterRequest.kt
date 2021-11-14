package com.spg.wnc.api.message.request

import com.spg.wnc.domain.model.user.UserType

data class UserRegisterRequest(
    val loginId: String,
    val password: String,
    val name: String,
    val userType: UserType,
    val career: List<String>?
)