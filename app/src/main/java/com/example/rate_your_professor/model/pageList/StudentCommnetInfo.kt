package com.example.rate_your_professor.model.pageList

data class StudentCommnetInfo(
        var commentId: String,
        var credit: String,
        var attendance: String,
        var grade: String,
        var textBook: String,
        var comment: String,
        var quality: String,
        var ratting: String = ""
)