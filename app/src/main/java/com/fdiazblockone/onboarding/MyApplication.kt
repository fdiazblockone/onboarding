package com.fdiazblockone.onboarding

import android.app.Application
import com.fdiazblockone.onboarding.di.DaggerMyAppComponent
import com.fdiazblockone.onboarding.di.MyAppComponent

class MyApplication : Application() {

    lateinit var component: MyAppComponent
        private set

    override fun onCreate() {
        super.onCreate()

        component = DaggerMyAppComponent
            .factory()
            .create(this)
    }
}