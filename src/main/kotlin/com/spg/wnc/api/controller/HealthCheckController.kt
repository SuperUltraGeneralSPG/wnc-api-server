package com.spg.wnc.api.controller

import io.swagger.annotations.ApiOperation
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@Controller("/api/ping")
class HealthCheckController {
    @ApiOperation(value = "서버 헬스체크", notes = "서버 헬스체크 API")
    @GetMapping
    fun helloServer(): String {
        return "SERVER HEALTH GOOD AND MY NAME IS DUDU"
    }
}