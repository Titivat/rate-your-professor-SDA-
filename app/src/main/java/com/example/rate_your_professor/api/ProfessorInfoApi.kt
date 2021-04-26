package com.example.rate_your_professor.api

import com.example.rate_your_professor.model.apiCall.couseCode.CouseCode
import com.example.rate_your_professor.model.apiCall.profesorInfo.ProfessorModel
import com.example.rate_your_professor.model.apiCall.summitInfo.SummitModel
import com.example.rate_your_professor.model.apiCall.studentComment.StudentComment
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path


interface ProfessorInfoApi{
    @GET("api/professor/get")
    fun getProfessorInfo(): Call<ProfessorModel>

    @GET("api/rating/get/{Id}")
    fun getStudentCommentInfo(@Path("Id") id: String): Call<StudentComment>

    @GET("api/coursecode/get/{Id}")
    fun getCouseCode(@Path("Id") id: String): Call<CouseCode>

    @POST("api/rating/create")
    fun postSummit(@Body post: SummitModel): Call<SummitModel>

    companion object {
        operator fun invoke(): ProfessorInfoApi {
            return Retrofit.Builder()
                .baseUrl("https://kmitlsdaproject.herokuapp.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ProfessorInfoApi::class.java)
        }
    }
}

