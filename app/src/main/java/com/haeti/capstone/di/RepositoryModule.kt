package com.haeti.capstone.di

import com.haeti.capstone.data.repository.PredictRepositoryImpl
import com.haeti.capstone.domain.repository.PredictRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {
    @Binds
    @Singleton
    fun bindPredictRepository(
        predictRepositoryImpl: PredictRepositoryImpl
    ): PredictRepository
}