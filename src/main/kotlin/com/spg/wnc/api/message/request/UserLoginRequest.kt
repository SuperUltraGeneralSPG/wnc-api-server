package com.spg.wnc.api.message.request

data class UserLoginRequest(
    val id: String,
    val password: String
)