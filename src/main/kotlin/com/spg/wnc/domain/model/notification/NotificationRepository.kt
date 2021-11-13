package com.spg.wnc.domain.model.notification

import org.springframework.data.jpa.repository.JpaRepository
import javax.transaction.Transactional

interface NotificationRepository : JpaRepository<Notification, Long> {
    fun findByIdAndConfirmedIsFalse(id: Long): List<Notification>

    @Transactional
    fun deleteAllByUserId(userId: Long)
}