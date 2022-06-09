package com.brickmate.houserepairingcompose.di

import com.brickmate.houserepairingcompose.api_service.login.LoginService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class APIModule {


    @Provides
    @Singleton
    fun provideLoginApiService( retrofit: Retrofit)
            : LoginService = retrofit.create(LoginService::class.java)
}