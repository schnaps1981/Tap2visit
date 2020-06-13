package com.test.tap2visit.mvp.views

import com.test.tap2visit.network.entity.Article
import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.SkipStrategy
import moxy.viewstate.strategy.StateStrategyType
import moxy.viewstate.strategy.alias.AddToEndSingle
import moxy.viewstate.strategy.alias.Skip

interface NewsListView : MvpView {
    @StateStrategyType(value = SkipStrategy::class)
    fun showNews(news : List<Article>)

    @StateStrategyType(value = SkipStrategy::class)
    fun showEmptyLoadingProgress(show: Boolean)

    @StateStrategyType(value = SkipStrategy::class)
    fun showEmptyNews(show: Boolean)

    @StateStrategyType(value = SkipStrategy::class)
    fun showRefreshIndicator(show: Boolean)

    @StateStrategyType(value = SkipStrategy::class)
    fun showError(error: Throwable)

    @StateStrategyType(value = SkipStrategy::class)
    fun showLoadNextPageIndicator(show: Boolean)


}