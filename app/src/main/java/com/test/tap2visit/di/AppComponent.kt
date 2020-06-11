package com.test.tap2visit.di.modules

import com.test.tap2visit.mvp.models.RecieveNews
import com.test.tap2visit.ui.fragments.NewsListFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        ContextModule::class,
        ApiClientModule::class
    ]
)

interface AppComponent {
    fun inject (receiveNews : RecieveNews)

    fun inject(newsListFragment: NewsListFragment)
}