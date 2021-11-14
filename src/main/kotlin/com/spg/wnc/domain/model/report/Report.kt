package com.spg.wnc.domain.model.report

import javax.persistence.*

@Entity
data class Report(
    @Id @Column(name = "report_id") @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0L,

    val reporterId: Long,

    val targetId: Long,

    @Column(length = 200)
    val comment: String
)