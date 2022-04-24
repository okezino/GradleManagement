package com.example.gradlemangement

import com.google.gson.Gson
import okhttp3.Interceptor
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.Response
import okhttp3.ResponseBody

class Hadd : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        var mediaType = "text/plain; charset=utf-8".toMediaTypeOrNull()
        var token = UserResponse("okhttploout")

        var responseBody = ResponseBody.create(mediaType, Gson().toJson(token))
        var res = chain.proceed(request).newBuilder().code(300).body(responseBody).build()

        return res
    }
}