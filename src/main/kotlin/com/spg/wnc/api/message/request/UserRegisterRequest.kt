package com.spg.wnc.api.message.request

import com.spg.wnc.domain.model.user.UserType

data class UserRegisterRequest(
    val id: String,
    val password: String,
    val memberType: UserType,
    val career: List<String>?
)