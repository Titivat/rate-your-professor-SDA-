package com.example.rate_your_professor.model.apiCall.summitInfo

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class SummitModel(
    val course_code: String,
    val rating: Float,
    val difficulty: Float,
    val takeagain: Boolean,
    val credit: Boolean,
    val textbook: Boolean,
    val attendance: Boolean,
    val grade: String,
    val comments: String
)