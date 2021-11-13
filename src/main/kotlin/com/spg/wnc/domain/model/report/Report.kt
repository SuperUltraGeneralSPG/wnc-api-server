package com.spg.wnc.domain.model.report

import javax.persistence.*

@Entity
data class Report(
    @Id @Column(name = "report_id") @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    val reporterId: Long,

    val targetId: Long,

    val comment: String
)