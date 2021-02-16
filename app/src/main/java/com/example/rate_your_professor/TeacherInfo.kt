package com.example.rate_your_professor

data class TeacherInfo(
        var teacherName: String,
        var ratting: Float,
        var wouldTakeAgainPercen: Int,
        var levelOfDifficulty: Float,
        var startColour: String = ""
)