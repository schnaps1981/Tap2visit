package com.test.tap2visit.di.modules

import dagger.Module
import dagger.Provides
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.Router
import javax.inject.Singleton

@Module
class NavigationModule {
    private val cicerone : Cicerone<Router> = Cicerone.create()

    @Provides
    @Singleton
    fun providesRouter() : Router = cicerone.router

    @Provides
    @Singleton
    fun providesNavigationHolder() : NavigatorHolder = cicerone.navigatorHolder

}