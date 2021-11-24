package com.galileo.app

import android.app.Application
import com.galileo.app.BuildConfig
import com.galileo.app.di.appModule
import org.koin.core.context.GlobalContext.startKoin
import timber.log.Timber
import org.koin.android.ext.koin.androidContext

class GalileoApplication : Application(){
    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
        startKoin {
            androidContext(this@GalileoApplication)
            modules(appModule)
        }
    }
}