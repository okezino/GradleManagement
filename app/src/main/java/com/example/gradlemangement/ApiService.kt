package com.example.gradlemangement

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {
    @POST("login")
    fun login(@Body user : User) : Call<UserResponse>

    @POST("login")
  suspend fun loginn(@Body user : User) : Response<UserResponse>

}