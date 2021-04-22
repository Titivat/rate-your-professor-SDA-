package com.example.rate_your_professor.model.apiCall.studentComment

data class StudentComment(
        val page: Int,
        val per_page: Int,
        val total: Int,
        val total_pages: Int,
        val data: List<CommentData>,
        val support: CommentSupport
)