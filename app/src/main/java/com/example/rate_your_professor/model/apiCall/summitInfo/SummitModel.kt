package com.example.rate_your_professor.model.apiCall.summitInfo

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class SummitModel(
    val name: String,
    val job: String
)