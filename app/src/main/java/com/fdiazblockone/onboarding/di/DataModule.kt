package com.fdiazblockone.onboarding.di

import com.fdiazblockone.onboarding.data.repositories.ListRepository
import com.fdiazblockone.onboarding.data.sources.LocalDataSource
import com.fdiazblockone.onboarding.data.sources.RemoteDataSource
import dagger.Module
import dagger.Provides

@Module
class DataModule {

    @Provides
    fun listRepositoryProvider(
        localDataSource: LocalDataSource,
        remoteDataSource: RemoteDataSource
    ) = ListRepository(localDataSource,remoteDataSource)
}