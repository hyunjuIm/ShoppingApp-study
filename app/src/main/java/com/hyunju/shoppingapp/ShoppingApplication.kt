package com.hyunju.shoppingapp

import android.app.Application
import com.hyunju.shoppingapp.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class ShoppingApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger(Level.ERROR)
            androidContext(this@ShoppingApplication)
            modules(appModule)
        }
    }
}