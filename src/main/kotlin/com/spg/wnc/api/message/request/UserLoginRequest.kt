package com.spg.wnc.api.message.request

data class UserLoginRequest(
    val loginId: String,
    val password: String
)