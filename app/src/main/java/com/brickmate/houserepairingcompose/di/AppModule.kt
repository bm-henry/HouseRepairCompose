package com.brickmate.houserepairingcompose.di

import com.brickmate.houserepairingcompose.model.coroutines.CoroutineDispatcherProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    fun provideCoroutineDispatcher() = CoroutineDispatcherProvider()
}