package com.spg.wnc.domain.model.teacher

import com.spg.wnc.infra.persistence.StringListConverter
import javax.persistence.*

@Entity
data class Teacher(
    @Id @Column(name = "teacher_id") @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0L,

    val userId: Long,

    val isBlackList: Boolean,

    @Convert(converter = StringListConverter::class)
    var career: List<String>?,

    val evaluationCount: Int,

    val evaluationSum: Int
) {
    companion object {
        fun new(userId: Long, career: List<String>?) = Teacher(
            userId = userId,
            isBlackList = false,
            career = career,
            evaluationCount = 0,
            evaluationSum = 0
        )
    }
}