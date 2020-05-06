package com.fdiazblockone.onboarding.di

import android.app.Application
import com.fdiazblockone.onboarding.presentation.detail.DetailFragmentComponent
import com.fdiazblockone.onboarding.presentation.detail.DetailFragmentModule
import com.fdiazblockone.onboarding.presentation.list.ListFragmentComponent
import com.fdiazblockone.onboarding.presentation.list.ListFragmentModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, DataModule::class])
interface MyAppComponent {

    fun plus(module: ListFragmentModule): ListFragmentComponent
    fun plus(module: DetailFragmentModule): DetailFragmentComponent

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance app: Application): MyAppComponent
    }
}
