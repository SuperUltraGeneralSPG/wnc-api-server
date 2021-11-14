package com.spg.wnc.domain.model.tutoring

import com.spg.wnc.api.message.request.TutoringGenerateRequest
import com.spg.wnc.infra.persistence.LongListConverter
import java.time.LocalDateTime
import javax.persistence.*

@Entity
data class Tutoring (
    @Id @Column(name = "tutoring_id") @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0L,

    val teacherId: Long,

    var title: String,

    @Column(length = 500)
    var description: String,

    @Enumerated(EnumType.STRING)
    @Column(length = 30)
    var type: TutoringType,

    @Enumerated(EnumType.STRING)
    @Column(length = 30)
    var status: TutoringStatus,

    @Convert(converter = LongListConverter::class)
    var studentList: MutableList<Long>,

    var recruitNumber: Int,

    var recruitEndDate: LocalDateTime,

    val createdAt: LocalDateTime,

    var updatedAt: LocalDateTime
) {
    companion object{
        fun new (tutoringGenerateRequest: TutoringGenerateRequest, teacherId: Long) = Tutoring(
            teacherId = teacherId,
            title = tutoringGenerateRequest.title,
            description = tutoringGenerateRequest.description,
            type = tutoringGenerateRequest.type,
            status = TutoringStatus.RECRUITING,
            studentList = mutableListOf(),
            recruitNumber = tutoringGenerateRequest.recruitNumber,
            recruitEndDate = tutoringGenerateRequest.recruitEndDate,
            createdAt = LocalDateTime.now(),
            updatedAt = LocalDateTime.now()
        )
    }
}