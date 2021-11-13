package com.spg.wnc.api.message.request

data class TutoringJoinRequest(
    val userId: Long,
    val tutoringId: Long
)