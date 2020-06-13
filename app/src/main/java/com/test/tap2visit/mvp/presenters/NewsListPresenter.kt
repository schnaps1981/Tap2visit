package com.test.tap2visit.mvp.presenters

import com.test.tap2visit.app.App
import com.test.tap2visit.global.Paginator
import com.test.tap2visit.mvp.models.NetworkClient
import com.test.tap2visit.mvp.views.NewsListView
import com.test.tap2visit.network.entity.Article
import com.test.tap2visit.network.entity.Categories
import com.test.tap2visit.ui.navigation.Screens
import moxy.InjectViewState
import moxy.MvpPresenter
import ru.terrakok.cicerone.Router
import timber.log.Timber
import javax.inject.Inject

@InjectViewState
class NewsListPresenter : MvpPresenter<NewsListView>() {

    @Inject
    lateinit var router: Router
    @Inject
    lateinit var networkClient: NetworkClient

    var currentCategory = Categories.NO_CATEGORY

    init {
        App.instance.inject(this)
    }

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        paginator.refresh()
    }

    private var paginator = Paginator(requestFactory = {
        networkClient.recieveNews(category = currentCategory, page = it)
    },
        viewController = object : Paginator.ViewController<Article> {
            override fun showEmptyProgress(show: Boolean) {
                viewState.showEmptyLoadingProgress(show)
            }

            override fun showEmptyError(show: Boolean, error: Throwable?) {
                Timber.d("showEmptyError ${error?.message}")
                error?.let { viewState.showError(it) }
            }

            override fun showEmptyView(show: Boolean) {
                viewState.showEmptyNews(show)
            }

            override fun showData(show: Boolean, data: List<Article>) {
                viewState.showNews(data)
            }

            override fun showErrorMessage(error: Throwable) {
                viewState.showError(error)

            }

            override fun showRefreshProgress(show: Boolean) {
                viewState.showRefreshIndicator(show)
            }

            override fun showPageProgress(show: Boolean) {
                viewState.showLoadNextPageIndicator(show)
            }
        })

    fun applyNewCategory(category: Categories) {
        currentCategory = category
        //paginator.refresh()
        paginator.init()
    }

    fun refreshNews() = paginator.refresh()
    fun loadNextPage() = paginator.loadNewPage()

    override fun onDestroy() {
        super.onDestroy()
        paginator.release()
    }

    fun openNewsDetails() {
        router.navigateTo(Screens.NewsDetailNav())
    }
}