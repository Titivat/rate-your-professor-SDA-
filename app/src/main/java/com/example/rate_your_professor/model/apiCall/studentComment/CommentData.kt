package com.example.rate_your_professor.model.apiCall.studentComment

data class CommentData(
      val code: String,
      val name: String,
      val rating: Float,
      val difficulty: Float,
      val takeagain: Boolean,
      val credit: Boolean,
      val textbook: Boolean,
      val attendance: Boolean,
      val grade: String,
      val comments: String
)
