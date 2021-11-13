package com.spg.wnc.domain.model.notification

import java.time.LocalDateTime
import javax.persistence.*

@Entity
data class Notification(
    @Id @Column(name = "notification_id") @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0L,

    val userId: Long,

    @Enumerated(EnumType.STRING)
    @Column(length = 200)
    var message: NotificationMessage,

    var isConfirmed: Boolean,

    val createdAt: LocalDateTime,

    var updatedAt: LocalDateTime
)