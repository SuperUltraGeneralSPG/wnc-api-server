package com.spg.wnc.application

import com.spg.wnc.api.message.request.UserDeregisterRequest
import com.spg.wnc.api.message.request.UserInfoModifyRequest
import com.spg.wnc.api.message.request.UserLoginRequest
import com.spg.wnc.api.message.request.UserRegisterRequest
import com.spg.wnc.domain.common.ResultResponseCode
import com.spg.wnc.domain.model.notification.NotificationRepository
import com.spg.wnc.domain.model.student.Student
import com.spg.wnc.domain.model.student.StudentRepository
import com.spg.wnc.domain.model.teacher.Teacher
import com.spg.wnc.domain.model.teacher.TeacherRepository
import com.spg.wnc.domain.model.tutoring.TutoringRepository
import com.spg.wnc.domain.model.user.User
import com.spg.wnc.domain.model.user.UserRepository
import com.spg.wnc.domain.model.user.UserType
import org.springframework.stereotype.Service
import java.lang.Exception
import kotlin.math.log

@Service
class UserService(
    private val userRepository: UserRepository,
    private val studentRepository: StudentRepository,
    private val teacherRepository: TeacherRepository,
    private val tutoringRepository: TutoringRepository,
    private val notificationRepository: NotificationRepository
) {
    fun register(request: UserRegisterRequest): Boolean {
        with(request) {
            val user = User.of(id,password,userType)
            userRepository.saveAndFlush(user)

            when(userType) {
                UserType.TEACHER -> {
                    val teacher = Teacher.new(user.id, career)
                    teacherRepository.saveAndFlush(teacher)
                }
                UserType.STUDENT -> {
                    val student = Student.new(user.id)
                    studentRepository.saveAndFlush(student)
                }
                else -> {}
            }
        }

        return true
    }

    fun login(request: UserLoginRequest): User? {
        return getUserByLoginId(request.loginId)
    }

    fun deregister(request: UserDeregisterRequest): Boolean {
        userRepository.deleteById(request.userId)
        studentRepository.deleteByUserId(request.userId)
        teacherRepository.deleteByUserId(request.userId)
        notificationRepository.deleteAllByUserId(request.userId)
        return true
    }

    fun modifyUserInfo(request: UserInfoModifyRequest): Boolean {
        val user = userRepository.getById(request.userId)
        user.password = request.password
        if (request.userType == UserType.TEACHER) {
            val teacher = teacherRepository.findByUserId(user.id)
            teacher.career = request.career
            teacherRepository.saveAndFlush(teacher)
        }
        userRepository.saveAndFlush(user)
        return true
    }

    fun getUser(userId: Long): User {
        return userRepository.getById(userId)
    }

    fun loginIdOverlapCheck(loginId: String): Boolean {
        return userRepository.findByLoginId(loginId) == null
    }

    private fun getUserByLoginId(loginId: String): User {
        return userRepository.findByLoginId(loginId) ?: throw Exception()
    }
}