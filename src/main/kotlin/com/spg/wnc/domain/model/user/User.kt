package com.spg.wnc.domain.model.user

import com.spg.wnc.infra.persistence.StringListConverter
import java.time.LocalDateTime
import javax.persistence.*

@Entity
data class User(
    @Id @Column(name = "user_id") @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    val typeId: Long,

    val loginId: String,

    val password: String,

    @Enumerated(EnumType.STRING)
    @Column(length = 30)
    val userType: UserType,

    val createdAt: LocalDateTime,

    val updatedAt: LocalDateTime
)