package com.spg.wnc.application

import com.spg.wnc.domain.model.notification.Notification
import com.spg.wnc.domain.model.notification.NotificationRepository
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class NotificationService(
    private val notificationRepository: NotificationRepository
) {
    fun getAllNotification(userId: Long): List<Notification> {
        return notificationRepository.findAllByUserId(userId)
    }

    fun getNotificationNotConfirmed(userId: Long): List<Notification> {
        return getNotificationNotConfirmed(userId)
    }

    fun confirmNotification(notificationId: Long): Boolean {
        val notification = notificationRepository.getById(notificationId)
        notification.isConfirmed = true
        notification.updatedAt = LocalDateTime.now()
        notificationRepository.saveAndFlush(notification)
        return true
    }

    fun deleteNotification(notificationId: Long): Boolean {
        notificationRepository.deleteById(notificationId)
        return true
    }
}