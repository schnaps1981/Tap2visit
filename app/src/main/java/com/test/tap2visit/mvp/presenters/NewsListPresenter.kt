package com.test.tap2visit.mvp.presenters

import com.test.tap2visit.app.App
import com.test.tap2visit.global.Paginator
import com.test.tap2visit.mvp.views.NewsListView
import com.test.tap2visit.network.api.entity.Article
import moxy.InjectViewState
import moxy.MvpPresenter
import ru.terrakok.cicerone.Router
import javax.inject.Inject

@InjectViewState
class NewsListPresenter : MvpPresenter<NewsListView>() {
    @Inject
    lateinit var router: Router

    lateinit var paginator: Paginator<Article>

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        App.instance.inject(this)

    }
}