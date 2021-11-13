package com.spg.wnc.domain.model.user

import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User, Long> {
    fun findByLoginId(loginId: String): User?
}