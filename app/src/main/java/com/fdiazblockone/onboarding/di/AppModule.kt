package com.fdiazblockone.onboarding.di

import android.app.Application
import androidx.room.Room
import com.fdiazblockone.onboarding.data.sources.LocalDataSource
import com.fdiazblockone.onboarding.data.sources.RemoteDataSource
import com.fdiazblockone.onboarding.framework.database.AppDataBase
import com.fdiazblockone.onboarding.framework.database.RoomDataSource
import com.fdiazblockone.onboarding.framework.network.Network
import com.fdiazblockone.onboarding.framework.network.NetworkDataSource
import com.fdiazblockone.onboarding.framework.network.NetworkService
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
class AppModule {

    @Provides
    @Singleton
    fun databaseProvider(app: Application) = Room.databaseBuilder(
        app,
        AppDataBase::class.java,
        "app-db"
    ).build()

    @Provides
    @Singleton
    fun networkProvider() = Network("https://eos.greymass.com/v1/chain/")

    @Provides
    fun localDataSourceProvider(db: AppDataBase): LocalDataSource = RoomDataSource(db)

    @Provides
    fun remoteDataSourceProvider(network: Network): RemoteDataSource = NetworkDataSource(network)
}