package com.spg.wnc.application

import com.spg.wnc.api.message.request.UserDeregisterRequest
import com.spg.wnc.api.message.request.UserInfoModifyRequest
import com.spg.wnc.api.message.request.UserLoginRequest
import com.spg.wnc.api.message.request.UserRegisterRequest
import com.spg.wnc.api.message.response.UserInfoResponse
import com.spg.wnc.domain.common.ErrorCode
import com.spg.wnc.domain.common.ResultResponseCode
import com.spg.wnc.domain.common.SpgException
import com.spg.wnc.domain.model.notification.NotificationRepository
import com.spg.wnc.domain.model.student.Student
import com.spg.wnc.domain.model.student.StudentRepository
import com.spg.wnc.domain.model.teacher.Teacher
import com.spg.wnc.domain.model.teacher.TeacherRepository
import com.spg.wnc.domain.model.tutoring.TutoringRepository
import com.spg.wnc.domain.model.user.User
import com.spg.wnc.domain.model.user.UserRepository
import com.spg.wnc.domain.model.user.UserType
import org.slf4j.LoggerFactory
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
    private val logger = LoggerFactory.getLogger(this::class.java)

    fun register(request: UserRegisterRequest): Boolean {
        with(request) {
            val user = User.from(request)
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
        val user = getUserByLoginId(request.loginId)
        if (request.password != user.password) {
            throw SpgException(ErrorCode.PASSWORD_WRONG)
        }
        return user
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

    fun getUserInfo(userId: Long): UserInfoResponse {
        val user = userRepository.getById(userId)
        val career = if (user.userType == UserType.TEACHER) {
            teacherRepository.findByUserId(user.id).career
        } else {
            null
        }
        return UserInfoResponse.from(user, career)
    }

    fun loginIdOverlapCheck(loginId: String): Boolean {
        logger.info(userRepository.findByLoginId(loginId).toString())
        return userRepository.findByLoginId(loginId) != null
    }

    private fun getUserByLoginId(loginId: String): User {
        return userRepository.findByLoginId(loginId)
            ?: throw SpgException(ErrorCode.UNIDENTIFIED_LOGIN_ID)
    }
}