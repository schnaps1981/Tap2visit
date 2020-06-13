package com.test.tap2visit.app

import android.app.Application
import com.test.tap2visit.BuildConfig
import com.test.tap2visit.app.di.AppComponent
import com.test.tap2visit.app.di.DaggerAppComponent
import com.test.tap2visit.app.di.modules.ContextModule
import timber.log.Timber
import timber.log.Timber.DebugTree


class App : Application(){

    companion object{
        lateinit var instance : AppComponent
    }

    override fun onCreate() {
        super.onCreate()

        instance = DaggerAppComponent.builder()
            .contextModule(ContextModule(applicationContext))
            .build()

        initLogger()
    }

    private fun initLogger() {
        if (BuildConfig.DEBUG) {
            Timber.plant(DebugTree())
        } else {
            Timber.plant(object : Timber.Tree() {
                override fun log(priority: Int, tag: String?, message: String, t: Throwable?) {
                }
            })
        }
    }
}