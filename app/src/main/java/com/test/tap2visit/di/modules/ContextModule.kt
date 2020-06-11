package com.test.tap2visit.di.modules

import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ContextModule(private val context : Context) {
    @Provides
    @Singleton
    fun provideContext() = context;

}