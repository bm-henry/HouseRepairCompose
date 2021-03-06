package com.brickmate.houserepairingcompose.di

import com.brickmate.houserepairingcompose.api_service.inbox.InboxService
import com.brickmate.houserepairingcompose.api_service.login.LoginService
import com.brickmate.houserepairingcompose.api_service.offer.OfferService
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

    @Provides
    @Singleton
    fun provideOfferApiService( retrofit: Retrofit)
            : OfferService = retrofit.create(OfferService::class.java)

    @Provides
    @Singleton
    fun provideInboxApiService( retrofit: Retrofit)
            : InboxService = retrofit.create(InboxService::class.java)
}