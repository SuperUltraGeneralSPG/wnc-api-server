package com.spg.wnc.domain.model.tutoring

import org.springframework.data.jpa.repository.JpaRepository

interface TutoringRepository : JpaRepository<Tutoring, Long> {
    fun findByTeacherId(teacherId: Long): List<Tutoring>

    fun findByTeacherIdAndStatus(teacherId: Long, status: TutoringStatus): List<Tutoring>
}