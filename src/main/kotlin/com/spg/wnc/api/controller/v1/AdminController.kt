package com.spg.wnc.api.controller.v1

import com.spg.wnc.domain.model.notification.Notification
import com.spg.wnc.domain.model.user.User
import io.swagger.annotations.ApiOperation
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@Controller("/api/v1/admin")
class AdminController {
    @ApiOperation(value = "회원 전체 목록 조회", notes = "회원 전체 목록 조회 API")
    @GetMapping("/inquiry/user/all")
    fun getNotificationNotConfirmed() : List<User> {
        return listOf()
    }
}