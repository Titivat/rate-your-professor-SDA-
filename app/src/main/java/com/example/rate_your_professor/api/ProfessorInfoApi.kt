package com.example.rate_your_professor.api

import com.example.rate_your_professor.model.apiCall.profesorInfo.ProfessorModel
import com.example.rate_your_professor.model.apiCall.summitInfo.SummitModel
import com.example.rate_your_professor.model.apiCall.studentComment.StudentComment
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST


interface ProfessorInfoApi{
    @GET("users?page=2")
    fun getProfessorInfo(): Call<ProfessorModel>

    @GET("unknown")
    fun getStudentCommentInfo(): Call<StudentComment>

    @POST("users")
    fun postSummit(@Body post: SummitModel): Call<SummitModel>

    companion object {
        operator fun invoke(): ProfessorInfoApi {
            return Retrofit.Builder()
                .baseUrl("https://reqres.in/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ProfessorInfoApi::class.java)
        }
    }
}

