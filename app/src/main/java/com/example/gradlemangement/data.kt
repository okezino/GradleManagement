package com.example.gradlemangement

data class User(val email : String , val password : String)

data class UserResponse( val token : String)

const val BASE_URI   = "https://reqres.in/api/"