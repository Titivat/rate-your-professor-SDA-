package com.example.rate_your_professor.model.apiCall.profesorInfo

data class ProfessorData(
        val id: Int,
        val name: String,
        val rating: Float,
        val difficulty: Float,
        val takeagain: Float
)
