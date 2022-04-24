package com.example.gradlemangement

sealed class Resource<out T>(val data : T? = null, val message : String? = null) {
    data class Success<T>(val datas : T) : Resource<T>(datas)
    data class Failure<T>(val messages : String ) : Resource<T>(message = messages)
    data class Loading<T>(val messages: String) : Resource<T>(message = messages)
}