package com.example.dagger2application.network

import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class RetrofitClass {

    val baseUrl = "https://gorest.co.in/public/v2/"

    @Singleton
    @Provides
    fun getRetrofitInterfaceService(retrofit: Retrofit) : RetrofitInterface {
        return retrofit.create(RetrofitInterface::class.java)
    }

    @Singleton
    @Provides
    fun getRetrofitInstance() : Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

}