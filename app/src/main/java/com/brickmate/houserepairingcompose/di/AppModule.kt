package com.brickmate.houserepairingcompose.di

import com.brickmate.houserepairingcompose.model.coroutines.CoroutineDispatcherProvider
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Singleton
    @Provides
    fun provideCoroutineDispatcher() = CoroutineDispatcherProvider()

    @Singleton
    @Provides
    fun provideGson() = Gson()




}