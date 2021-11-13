package com.spg.wnc.domain.model.notification

import org.springframework.data.jpa.repository.JpaRepository

interface NotificationRepository : JpaRepository<Notification, Long> {
    fun findByIdAndConfirmedIsFalse(id: Long): List<Notification>
}