package com.spg.wnc.api.message.response

import com.spg.wnc.domain.model.user.User
import com.spg.wnc.domain.model.user.UserType
import java.time.LocalDateTime

data class UserInfoResponse(
    val id: Long,
    val loginId: String,
    val password: String,
    val name: String,
    val userType: UserType,
    val createdAt: LocalDateTime,
    val career: List<String>?
) {
    companion object {
        fun from(user: User, career: List<String>?) = UserInfoResponse(
            id = user.id,
            loginId = user.loginId,
            password = user.password,
            name = user.name,
            userType = user.userType,
            createdAt = user.createdAt,
            career = career
        )

    }
}