package com.spg.wnc.domain.model.user

enum class UserRegisterMessage(
    val value: String
) {
    REGISTER_SUCCESS("회원 가입에 성공했습니다! 등록한 아이디로 로그인 해 주세요"),
    REGISTER_ERROR("회원 가입에 실패했습니다. 잠시 후 재시도해 주세요")
}