package com.haeti.capstone.di

import com.haeti.capstone.data.service.MainService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ServiceModule {
    private inline fun <reified T> Retrofit.create(): T = create(T::class.java)

    @Provides
    @Singleton
    fun provideMainService(retrofit: Retrofit): MainService = retrofit.create()
}