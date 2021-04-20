package com.example.rate_your_professor

data class StudentCommnetInfo(
        var commentId: String,
        var credit: String,
        var attendance: String,
        var grade: String,
        var textBook: String,
        var comment: String,
        var studyAgain: String,
        var ratting: String = ""
)