package com.test.tap2visit.app.di.modules

import com.test.tap2visit.MainActivity
import com.test.tap2visit.mvp.models.RecieveNews
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
        NavigationModule::class
    ]
)

interface AppComponent {
    fun inject(activity: MainActivity)

    fun inject(receiveNews: RecieveNews)

    fun inject(newsListFragment: NewsListFragment)
    fun inject(newsDetailFragment: NewsDetailFragment)

    fun inject(newsListPresenter: NewsListPresenter)
    fun inject(newsDetailPresenter: NewsDetailPresenter)

}