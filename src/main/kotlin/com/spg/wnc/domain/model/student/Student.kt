package com.spg.wnc.domain.model.student

import com.spg.wnc.infra.persistence.StringListConverter
import javax.persistence.*

@Entity
data class Student(
    @Id @Column(name = "student_id") @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0L,

    val userId: Long
) {
    companion object {
        fun new(userId: Long) = Student(
            userId = userId
        )
    }
}