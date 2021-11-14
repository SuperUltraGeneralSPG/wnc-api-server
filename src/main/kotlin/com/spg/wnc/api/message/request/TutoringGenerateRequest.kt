package com.spg.wnc.api.message.request

import com.spg.wnc.domain.model.tutoring.TutoringType
import java.time.LocalDateTime

data class TutoringGenerateRequest(
    val userId: Long,
    val title: String,
    val description: String,
    val type: TutoringType,
    val recruitNumber: Int,
    val recruitEndDate: Long
)