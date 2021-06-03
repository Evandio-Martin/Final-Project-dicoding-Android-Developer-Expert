package com.dicoding.picodiploma.movietvshowapp

import android.app.Application
import com.dicoding.picodiploma.movietshowapp.core.di.databaseModule
import com.dicoding.picodiploma.movietshowapp.core.di.networkModule
import com.dicoding.picodiploma.movietshowapp.core.di.repositoryModule
import com.dicoding.picodiploma.movietvshowapp.di.useCaseModule
import com.dicoding.picodiploma.movietvshowapp.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.NONE)
            androidContext(this@MyApplication)
            modules(
                listOf(
                    databaseModule,
                    networkModule,
                    repositoryModule,
                    useCaseModule,
                    viewModelModule
                )
            )
        }
    }
}