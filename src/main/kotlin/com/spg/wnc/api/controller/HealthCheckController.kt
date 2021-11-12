package com.spg.wnc.api.controller

import io.swagger.annotations.ApiOperation
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@Controller("/ping")
class HealthCheckController {
    @ApiOperation(value = "서버 헬스체크", notes = "서버 헬스체크 API")
    @GetMapping("/pingping")
    fun helloServer(): String {
        return "SERVER HEALTH GOOD"
    }

    @ApiOperation(value = "서버 헬스체크2", notes = "서버 헬스체크 API2")
    @GetMapping("/pong")
    fun helloServer2(): String {
        return "PONG"
    }
}