package com.spg.wnc.api.message.request

data class TutoringQuitRequest(
    val userId: Long,
    val tutoringId: Long
)