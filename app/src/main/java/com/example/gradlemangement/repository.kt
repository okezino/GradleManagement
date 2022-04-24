package com.example.gradlemangement

import retrofit2.Response
import java.lang.Exception

class repository(val api: ApiService) {

    suspend fun login(a: User): Response<UserResponse> = execute {
        try {
            api.loginn(a)
        }catch (e : Exception){
            throw  e
        }
    }

    private suspend fun <T>execute(request : suspend () -> T) : T{
        return request()
    }

}