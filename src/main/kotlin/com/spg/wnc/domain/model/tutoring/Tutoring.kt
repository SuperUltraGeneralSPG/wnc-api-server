package com.spg.wnc.domain.model.tutoring

import java.time.LocalDateTime

data class Tutoring (
    val teacherId: Long,
    val title: String,
    val description: String,
    val type: TutoringType,
    val recruitNumber: Int,
    val recruitEndDate: LocalDateTime
)