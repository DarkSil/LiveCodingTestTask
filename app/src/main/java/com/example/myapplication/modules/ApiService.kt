package com.example.myapplication.modules

import com.example.myapplication.APIService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import retrofit2.Retrofit

@Module
@InstallIn(ActivityComponent::class)
object ApiService {

    @Provides
    fun provideAPIService(
        retrofit: Retrofit
    ) : APIService {
        return retrofit.create(APIService::class.java)
    }

}