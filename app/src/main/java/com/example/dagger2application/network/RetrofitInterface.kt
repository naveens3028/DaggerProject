package com.example.dagger2application.network

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET


interface RetrofitInterface {
    @GET("users")
    fun getUserData(): Call<ResponseBody>
}