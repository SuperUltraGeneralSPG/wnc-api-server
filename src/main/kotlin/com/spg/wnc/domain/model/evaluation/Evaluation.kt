package com.spg.wnc.domain.model.evaluation

import java.time.LocalDateTime
import javax.persistence.*

@Entity
data class Evaluation(
    @Id @Column(name = "evaluation_id") @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    val score: Int,

    @Column(length = 200)
    val comment: String,

    val createdAt: LocalDateTime,
)