package com.dev.rhyan.stutwear

import android.app.Application
import com.dev.rhyan.stutwear.data.di.apiModule
import com.dev.rhyan.stutwear.data.di.repositoryModule
import com.dev.rhyan.stutwear.data.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class Application : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@Application)
            modules(apiModule, repositoryModule, viewModelModule)
        }
    }
}