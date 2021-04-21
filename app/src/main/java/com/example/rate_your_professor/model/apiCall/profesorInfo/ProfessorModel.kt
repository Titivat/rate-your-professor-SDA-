package com.example.rate_your_professor.model.apiCall.profesorInfo

data class ProfessorModel (
        val page: Int,
        val per_page: Int,
        val total: Int,
        val total_pages: Int,
        val data: List<ProfessorData>,
        val support: ProfessorSupport
)





