package com.spg.wnc.domain.model.user

import com.spg.wnc.api.message.request.UserRegisterRequest
import com.spg.wnc.infra.persistence.StringListConverter
import java.time.LocalDateTime
import javax.persistence.*

@Entity
data class User(
    @Id @Column(name = "user_id") @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0L,

    val loginId: String,

    var password: String,

    var name: String,

    @Enumerated(EnumType.STRING)
    @Column(length = 30)
    val userType: UserType,

    val createdAt: LocalDateTime,

    var updatedAt: LocalDateTime
) {
    companion object {
        fun from(request: UserRegisterRequest) = User(
            loginId = request.loginId,
            password = request.password,
            name = request.name,
            userType = request.userType,
            createdAt = LocalDateTime.now(),
            updatedAt = LocalDateTime.now()
        )
    }
}