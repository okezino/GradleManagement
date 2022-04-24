package com.example.gradlemangement

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Retrofit {
    val logging = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    val hadd = Hadd()
    val okHttpClient: OkHttpClient = OkHttpClient()
        .newBuilder()
        .addInterceptor(logging)
     .build()

    val retrofit: Retrofit.Builder by lazy {
        Retrofit
            .Builder()
            .client(okHttpClient)
            .baseUrl(BASE_URI)
            .addConverterFactory(GsonConverterFactory.create())
    }

    val apiService = retrofit.build().create(ApiService::class.java)
}