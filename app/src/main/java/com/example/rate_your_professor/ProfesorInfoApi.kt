package com.example.rate_your_professor

import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST


interface ProfesorInfoApi{
    @GET("todos")
    fun getProfesorInfo(): Call<List<ProfesorInfoModel>>

    @GET("todos/1")
    fun getStudentCommentInfo(): Call<List<CommentInfoModel>>

    @POST("api/users")
    fun postSummit(@Body post: SummitModel): Call<SummitModel>

    companion object {
        operator fun invoke(): ProfesorInfoApi {
            return Retrofit.Builder()
                .baseUrl("https://reqres.in/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ProfesorInfoApi::class.java)
        }
    }
}

