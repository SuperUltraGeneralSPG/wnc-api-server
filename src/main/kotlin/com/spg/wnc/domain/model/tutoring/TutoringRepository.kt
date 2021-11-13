package com.spg.wnc.domain.model.tutoring

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import java.time.LocalDateTime

interface TutoringRepository : JpaRepository<Tutoring, Long> {
    fun findByTeacherId(teacherId: Long): List<Tutoring>

    fun findByTeacherIdAndStatus(teacherId: Long, status: TutoringStatus): List<Tutoring>

    fun findByStatus

    @Query(
        value = """
         UPDATE Tutoring t 
         SET t.status = :status
         WHERE t.recruitEndDate <= :referDate
        """
    )
    fun updateTutoringStatusByDate(
        @Param("status") status: TutoringStatus,
        @Param("referDate") date: LocalDateTime
    )
}