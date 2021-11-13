package com.spg.wnc.domain.model.tutoring

import com.spg.wnc.infra.persistence.LongListConverter
import java.time.LocalDateTime
import javax.persistence.*

@Entity
data class Tutoring (
    @Id @Column(name = "tutoring_id") @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0L,

    val teacherId: Long,

    val title: String,

    @Column(length = 500)
    val description: String,

    @Enumerated(EnumType.STRING)
    @Column(length = 30)
    val type: TutoringType,

    @Enumerated(EnumType.STRING)
    @Column(length = 30)
    val status: TutoringStatus,

    @Convert(converter = LongListConverter::class)
    val studentList: List<Long>,

    val recruitNumber: Int,

    val recruitEndDate: LocalDateTime
)