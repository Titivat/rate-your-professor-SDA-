package com.example.rate_your_professor.model.apiCall.studentComment

data class StudentComment(
        val ok: Boolean,
        val ratings: List<CommentData>
)