package com.spg.wnc.domain.model.teacher

import org.springframework.data.jpa.repository.JpaRepository
import javax.transaction.Transactional

interface TeacherRepository : JpaRepository<Teacher, Long> {
    @Transactional
    fun deleteByUserId(userId: Long)

    fun findByUserId(userId: Long): Teacher
}