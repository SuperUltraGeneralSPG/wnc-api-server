package com.spg.wnc.application

import com.spg.wnc.api.message.request.TutoringCloseRequest
import com.spg.wnc.api.message.request.TutoringGenerateRequest
import com.spg.wnc.api.message.request.TutoringJoinRequest
import com.spg.wnc.api.message.request.TutoringQuitRequest
import com.spg.wnc.domain.model.student.StudentRepository
import com.spg.wnc.domain.model.teacher.TeacherRepository
import com.spg.wnc.domain.model.tutoring.Tutoring
import com.spg.wnc.domain.model.tutoring.TutoringRepository
import com.spg.wnc.domain.model.tutoring.TutoringStatus
import com.spg.wnc.domain.model.user.UserRepository
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class TutoringService(
    private val studentRepository: StudentRepository,
    private val teacherRepository: TeacherRepository,
    private val tutoringRepository: TutoringRepository
) {
    fun openTutoring(request: TutoringGenerateRequest): Long {
        val teacher = teacherRepository.findByUserId(request.userId)
        val tutoring = Tutoring.new(request, teacher.id)
        tutoringRepository.saveAndFlush(tutoring)
        return tutoring.id
    }

    fun closeTutoring(request: TutoringCloseRequest): Boolean {
        val tutoring = tutoringRepository.getById(request.tutoringId)
        tutoring.status = TutoringStatus.CLOSED
        tutoring.updatedAt = LocalDateTime.now()
        return true
    }

    fun joinTutoring(request: TutoringJoinRequest): Boolean {
        val tutoring = tutoringRepository.getById(request.tutoringId)
        val student = studentRepository.findByUserId(request.userId)
        tutoring.studentList.add(student.id)
        tutoring.updatedAt = LocalDateTime.now()
        return true
    }

    fun quitTutoring(request: TutoringQuitRequest): Boolean {
        val tutoring = tutoringRepository.getById(request.tutoringId)
        val student = studentRepository.findByUserId(request.userId)
        tutoring.studentList.remove(student.id)
        tutoring.updatedAt = LocalDateTime.now()
        return true
    }

    fun inquiryTutoringList(): List<Tutoring> {
        updateTutoringStatus()
        return tutoringRepository.findAll()
    }

    fun inquiryTutoringDetail(tutoringId: Long): Tutoring {
        return tutoringRepository.getById(tutoringId)
    }

    private fun updateTutoringStatus() {
        tutoringRepository.updateTutoringStatusByDate(TutoringStatus.CLOSED, LocalDateTime.now())
    }
}