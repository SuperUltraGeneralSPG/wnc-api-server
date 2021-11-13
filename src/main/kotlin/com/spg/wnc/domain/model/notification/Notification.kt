package com.spg.wnc.domain.model.notification

import java.time.LocalDateTime
import javax.persistence.*

@Entity
data class Notification(
    @Id @Column(name = "notification_id") @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    val userId: Long,

    @Enumerated(EnumType.STRING)
    @Column(length = 200)
    val message: NotificationMessage,

    val isConfirmed: Boolean,

    val createdAt: LocalDateTime,

    val updatedAt: LocalDateTime
)