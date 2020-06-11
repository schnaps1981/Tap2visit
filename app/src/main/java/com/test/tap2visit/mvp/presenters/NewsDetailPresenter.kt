package com.test.tap2visit.mvp.presenters

import com.test.tap2visit.app.App
import com.test.tap2visit.mvp.views.NewsDetailsView
import moxy.InjectViewState
import moxy.MvpPresenter
import ru.terrakok.cicerone.Router
import javax.inject.Inject

@InjectViewState
class NewsDetailPresenter: MvpPresenter<NewsDetailsView>() {
    @Inject lateinit var router: Router

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        App.instance.inject(this)
    }

}