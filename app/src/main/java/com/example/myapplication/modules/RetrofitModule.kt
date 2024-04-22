package com.example.myapplication.modules

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module

@InstallIn(SingletonComponent::class)
object RetrofitModule {

    @Provides
    fun provideRetrofit() : Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://655395fc5449cfda0f2eedbd.mockapi.io")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

}