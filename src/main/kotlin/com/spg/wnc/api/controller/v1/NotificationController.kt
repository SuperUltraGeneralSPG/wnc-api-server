package com.spg.wnc.api.controller.v1

import com.spg.wnc.application.NotificationService
import com.spg.wnc.domain.common.ResultResponseCode
import com.spg.wnc.domain.model.notification.Notification
import io.swagger.annotations.ApiOperation
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@Controller("/api/v1/notification")
class NotificationController(
    private val notificationService: NotificationService
) {
    @ApiOperation(value = "미확인 알림 목록 가져오기", notes = "미확인 알림 목록 가져오기 API")
    @PostMapping("/inquiry/notConfirmed")
    fun getNotificationNotConfirmed(
        userId: Long
    ) : List<Notification> {
        return notificationService.getNotificationNotConfirmed(userId)
    }

    @ApiOperation(value = "전체 알림 목록 가져오기", notes = "전체 알림 목록 가져오기 API")
    @PostMapping("/inquiry/all")
    fun getNotification(
        userId: Long
    ) : List<Notification> {
        return notificationService.getAllNotification(userId)
    }

    @ApiOperation(value = "알림 확인", notes = "알림 확인 API")
    @PutMapping("/confirm")
    fun confirmNotification(
        notificationId: Long
    ) : ResultResponseCode {
        return if (notificationService.confirmNotification(notificationId)) {
            ResultResponseCode.SUCCESS
        } else {
            ResultResponseCode.FAIL
        }
    }

    @ApiOperation(value = "알림 삭재", notes = "알림 삭제 API")
    @PostMapping("/delete")
    fun deleteNotification(
        notificationId: Long
    ) : ResultResponseCode {
        return if (notificationService.deleteNotification(notificationId)) {
            ResultResponseCode.SUCCESS
        } else {
            ResultResponseCode.FAIL
        }
    }
}