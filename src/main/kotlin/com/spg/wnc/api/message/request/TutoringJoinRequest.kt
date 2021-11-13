package com.spg.wnc.api.message.request

data class TutoringJoinRequest(
    val studentId: Long,
    val tutoringId: Long
)