package com.spg.wnc.domain.model.student

import org.springframework.data.jpa.repository.JpaRepository
import javax.transaction.Transactional

interface StudentRepository : JpaRepository<Student, Long> {
    @Transactional
    fun deleteByUserId(userId: Long)

    fun findByUserId(userId: Long): Student
}