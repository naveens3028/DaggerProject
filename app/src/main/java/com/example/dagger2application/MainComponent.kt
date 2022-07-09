package com.example.dagger2application

import com.example.dagger2application.network.RetrofitClass
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [RetrofitClass::class])
interface MainComponent {
    fun inject (firstFragmentViewModel: FirstFragmentViewModel)
}