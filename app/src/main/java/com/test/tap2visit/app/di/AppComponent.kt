package com.test.tap2visit.app.di

import com.test.tap2visit.MainActivity
import com.test.tap2visit.app.di.modules.ApiClientModule
import com.test.tap2visit.app.di.modules.ContextModule
import com.test.tap2visit.app.di.modules.NavigationModule
import com.test.tap2visit.app.di.modules.NetworkClientModule
import com.test.tap2visit.mvp.models.NetworkClient
import com.test.tap2visit.mvp.presenters.NewsDetailPresenter
import com.test.tap2visit.mvp.presenters.NewsListPresenter
import com.test.tap2visit.ui.fragments.NewsDetailFragment
import com.test.tap2visit.ui.fragments.NewsListFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        ContextModule::class,
        ApiClientModule::class,
        NavigationModule::class,
        NetworkClientModule::class
    ]
)

interface AppComponent {
    fun inject(activity: MainActivity)

    fun inject(receiveNews: NetworkClient)

    fun inject(newsListFragment: NewsListFragment)
    fun inject(newsDetailFragment: NewsDetailFragment)

    fun inject(newsListPresenter: NewsListPresenter)
    fun inject(newsDetailPresenter: NewsDetailPresenter)

}