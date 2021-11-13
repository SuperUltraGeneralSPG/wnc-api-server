package com.spg.wnc.api.controller.v1

import com.spg.wnc.api.message.request.TutoringCloseRequest
import com.spg.wnc.api.message.request.TutoringGenerateRequest
import com.spg.wnc.api.message.request.TutoringJoinRequest
import com.spg.wnc.api.message.request.TutoringQuitRequest
import com.spg.wnc.api.message.response.TutoringGenerationResponse
import com.spg.wnc.application.TutoringService
import com.spg.wnc.domain.common.ResultResponseCode
import com.spg.wnc.domain.model.tutoring.Tutoring
import com.spg.wnc.domain.model.tutoring.TutoringStatus
import com.spg.wnc.domain.model.tutoring.TutoringType
import io.swagger.annotations.ApiOperation
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*
import java.time.LocalDateTime

@RestController
@Controller("/api/v1/tutoring")
class TutoringController(
    private val tutoringService: TutoringService
) {
    @ApiOperation(value = "과외 모집 생성", notes = "과외 생성 API (선생)")
    @PostMapping("/generation")
    fun openTutoring(
        request: TutoringGenerateRequest
    ) : TutoringGenerationResponse {
        val tutoringId = tutoringService.openTutoring(request)
        return TutoringGenerationResponse(tutoringId)
    }

    @ApiOperation(value = "과외 모집 마감", notes = "과외 마감 API (선생)")
    @PutMapping("/close")
    fun closeTutoring(
      request: TutoringCloseRequest
    ) : ResultResponseCode {
        return if (tutoringService.closeTutoring(request)) {
            ResultResponseCode.SUCCESS
        } else {
            ResultResponseCode.FAIL
        }
    }

    @ApiOperation(value = "과외 등록 신청", notes = "과의 등록 신청 API (학생)")
    @PostMapping("/join")
    fun joinTutoring(
        request: TutoringJoinRequest
    ) : ResultResponseCode {
        return if (tutoringService.joinTutoring(request)) {
            ResultResponseCode.SUCCESS
        } else {
            ResultResponseCode.FAIL
        }
    }

    @ApiOperation(value = "과외 해지", notes = "과외 탈퇴 API (학생)")
    @PostMapping("/quit")
    fun quitTutoring(
        request: TutoringQuitRequest
    ) : ResultResponseCode {
        return if (tutoringService.quitTutoring(request)) {
            ResultResponseCode.SUCCESS
        } else {
            ResultResponseCode.FAIL
        }
    }

    @ApiOperation(value = "과외 전체 목록 불러오기", notes = "과외 전체 목록 불러오기 API")
    @GetMapping("/list")
    fun inquiryTutoringList() : List<Tutoring> {
        return tutoringService.inquiryTutoringList()
    }

    @ApiOperation(value = "과외 상세 불러오기", notes = "과외 상세 불러오기 API")
    @GetMapping("/inquiry/{tutoringId}")
    fun inquiryTutoring(
        @PathVariable tutoringId: Long
    ) : Tutoring {
        return tutoringService.inquiryTutoringDetail(tutoringId)
    }
}