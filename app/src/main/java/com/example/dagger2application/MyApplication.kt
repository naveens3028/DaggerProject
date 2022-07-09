package com.example.dagger2application

import android.app.Application
import com.example.dagger2application.network.RetrofitClass

class MyApplication : Application() {

    private lateinit var mainComponent : MainComponent

    override fun onCreate() {
        super.onCreate()

        mainComponent = DaggerMainComponent.builder()
            .retrofitClass(RetrofitClass())
            .build()
    }

    fun getMainComponentInstance() : MainComponent{
        return mainComponent
    }

}