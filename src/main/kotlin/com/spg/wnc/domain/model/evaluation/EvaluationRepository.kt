package com.spg.wnc.domain.model.evaluation

import org.springframework.data.jpa.repository.JpaRepository
import javax.transaction.Transactional

interface EvaluationRepository : JpaRepository<Evaluation, Long> {
    @Transactional
    fun deleteAllByUserId(userId: Long)
}