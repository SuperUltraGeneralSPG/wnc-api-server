package com.spg.wnc.domain.model.notification

import org.springframework.data.jpa.repository.JpaRepository
import javax.transaction.Transactional

interface NotificationRepository : JpaRepository<Notification, Long> {
    fun findByUserIdAndConfirmedIsFalse(userId: Long): List<Notification>

    @Transactional
    fun deleteAllByUserId(userId: Long)

    fun findAllByUserId(userId: Long): List<Notification>
}