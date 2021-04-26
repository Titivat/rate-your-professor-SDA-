package com.example.rate_your_professor.model.pageList

data class TeacherInfo(
        var teacherName: String,
        var ratting: Float,
        var wouldTakeAgainPercen: Float,
        var levelOfDifficulty: Float,
        var startColour: String = ""
)