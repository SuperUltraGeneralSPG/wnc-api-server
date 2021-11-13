package com.spg.wnc.domain.model.teacher

import com.spg.wnc.infra.persistence.StringListConverter
import javax.persistence.*

@Entity
data class Teacher(
    @Id @Column(name = "teacher_id") @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    val userId: Long,

    val isBlackList: Boolean,

    @Convert(converter = StringListConverter::class)
    val career: List<String>,

    val evaluationCount: Int,

    val evaluationSum: Int
)