package com.spg.wnc.domain.model.user

import java.time.LocalDateTime

data class User(
    val id: Long,
    val typeId: Long,
    val loginId: String,
    val password: String,
    val userType: UserType,
    val career: List<String>,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime
)