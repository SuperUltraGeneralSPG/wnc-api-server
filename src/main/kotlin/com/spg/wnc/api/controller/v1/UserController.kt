package com.spg.wnc.api.controller.v1

import com.spg.wnc.api.message.request.UserDeregisterRequest
import com.spg.wnc.api.message.request.UserInfoModifyRequest
import com.spg.wnc.api.message.request.UserLoginRequest
import com.spg.wnc.api.message.request.UserRegisterRequest
import com.spg.wnc.api.message.response.UserLoginResponse
import com.spg.wnc.api.message.response.UserRegisterResponse
import com.spg.wnc.domain.common.ResultResponseCode
import com.spg.wnc.domain.model.user.UserType
import com.spg.wnc.domain.model.user.UserRegisterMessage
import io.swagger.annotations.ApiOperation
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@Controller("/api/v1/user")
class UserController {
    @ApiOperation(value = "회원 가입", notes = "회원 가입 API")
    @PostMapping("/register")
    fun register(
        request: UserRegisterRequest
    ) : UserRegisterResponse {
        // TODO: 내부구현
        return UserRegisterResponse(true, UserRegisterMessage.REGISTER_SUCCESS.value)
    }

    @ApiOperation(value = "회원 로그인", notes = "회원 로그인 API")
    @PostMapping("/login")
    fun login(
        request: UserLoginRequest
    ) : UserLoginResponse {
        // TODO: 내부구현
        return UserLoginResponse(1234556, UserType.STUDENT, 123123)
    }

    @ApiOperation(value = "회원 아이디 중복검사", notes = "회원 아이디 중복검사 API")
    @PostMapping("/overlap")
    fun overlapCheck(
        id: String
    ) : ResultResponseCode {
        // TODO: 내부구현
        return ResultResponseCode.PASS
    }

    @ApiOperation(value = "회원 정보 수정", notes = "회원 정보 수정 API")
    @PutMapping("/modify")
    fun modifyUserInfo(
        request: UserInfoModifyRequest
    ) : ResultResponseCode {
        // TODO: 내부구현
        return ResultResponseCode.SUCCESS
    }

    @ApiOperation(value = "회원 탈퇴", notes = "회원 탈퇴 API")
    @DeleteMapping("/deregister")
    fun deregister(
        request: UserDeregisterRequest
    ) : ResultResponseCode {
        // TODO: 내부구현
        return ResultResponseCode.SUCCESS
    }
}