package com.spg.wnc.api.message.request

data class TutoringQuitRequest(
    val studentId: Long,
    val tutoringId: Long
)