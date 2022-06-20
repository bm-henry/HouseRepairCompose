package com.brickmate.houserepairingcompose.di

import android.content.Context
import android.content.SharedPreferences
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKeys
import com.brickmate.houserepairingcompose.model.coroutines.CoroutineDispatcherProvider
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Qualifier
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


    @Singleton
    @Provides
    @SharePreferenceKeyAlias
    fun provideMasterKeyAlias() = MasterKeys.getOrCreate(MasterKeys.AES256_GCM_SPEC)

    @Singleton
    @Provides
    fun provideEncryptSharePref(
        @ApplicationContext context: Context,
        @SharePreferenceKeyAlias keyAlias: String
    ): SharedPreferences = EncryptedSharedPreferences.create(
        "secret_shared_prefs",
        keyAlias,
        context,
        EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
        EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
    )


    @Qualifier
    @Retention(AnnotationRetention.BINARY)
    annotation class SharePreferenceKeyAlias


}