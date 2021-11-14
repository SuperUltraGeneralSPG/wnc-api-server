package com.spg.wnc.domain.common

enum class ErrorCode(
    val message: String
) {
    UNEXPECTED_ERROR("서버 내부 오류(500) 입니다."),
    PASSWORD_WRONG("비밀번호 입력 오류입니다. 비밀번호를 확인해주세요."),
    UNIDENTIFIED_LOGIN_ID("가입되지 않은 ID 입니다. 아이디를 확인해주세요")
}