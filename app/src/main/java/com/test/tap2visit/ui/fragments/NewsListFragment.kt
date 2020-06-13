package com.test.tap2visit.ui.fragments

import android.os.Bundle
import android.view.*
import androidx.appcompat.widget.Toolbar
import androidx.core.os.bundleOf
import androidx.core.view.get
import androidx.core.view.size
import androidx.fragment.app.setFragmentResult
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.test.tap2visit.R
import com.test.tap2visit.app.App
import com.test.tap2visit.app.Constants
import com.test.tap2visit.global.BaseAdapterCallback
import com.test.tap2visit.global.enumValueOfOrNull
import com.test.tap2visit.mvp.presenters.NewsListPresenter
import com.test.tap2visit.mvp.views.NewsListView
import com.test.tap2visit.network.entity.Article
import com.test.tap2visit.network.entity.Categories
import com.test.tap2visit.ui.adapters.NewsListAdapter
import kotlinx.android.synthetic.main.news_list.*
import moxy.MvpAppCompatFragment
import moxy.presenter.InjectPresenter
import timber.log.Timber

class NewsListFragment : MvpAppCompatFragment(R.layout.news_list), NewsListView, BaseAdapterCallback<Article>,
    Toolbar.OnMenuItemClickListener {

    @InjectPresenter
    lateinit var presenter: NewsListPresenter
    val adapter = NewsListAdapter()

    companion object {
        fun getInstance(): NewsListFragment = NewsListFragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        App.instance.inject(this)

        initRecycler()
        initMenu()

        srl_news_refresh.setOnRefreshListener {
            presenter.refreshNews()
        }
    }

    private fun initMenu() {
        tb_toolbar.overflowIcon = context?.getDrawable(R.drawable.ic_baseline_filter_list_24)
        tb_toolbar.inflateMenu(R.menu.menu_main)
        tb_toolbar.setOnMenuItemClickListener(this)

        Categories.values().forEach {
            tb_toolbar.menu.add(0, it.ordinal, 0, it.name)
        }
    }

    override fun onMenuItemClick(item: MenuItem?): Boolean {
        val selectedCategory = enumValueOfOrNull<Categories>(item?.title.toString()) ?: return false
        presenter.applyNewCategory(category = selectedCategory)
        return false
    }

    private fun initRecycler() {
        rv_news_list.layoutManager = LinearLayoutManager(activity?.applicationContext)
        rv_news_list.adapter = adapter
        adapter.attachCallback(this)
    }

    override fun showNews(news: List<Article>) {
        adapter.updateItems(news)
    }

    override fun showEmptyLoadingProgress(show: Boolean) {
        pb_news_empty_loading.visibility = if (show) View.VISIBLE else View.GONE
    }

    override fun showEmptyNews(show: Boolean) {
        tv_news_empty_data.visibility = if (show) View.VISIBLE else View.GONE
    }

    override fun showRefreshIndicator(show: Boolean) {
        srl_news_refresh.isRefreshing = show
    }

    override fun showError(error: Throwable) {
        val parentLayout: View? = activity?.findViewById(android.R.id.content)
        parentLayout?.let { Snackbar.make(it, error.message.toString(), Snackbar.LENGTH_SHORT).show() }
    }

    override fun showLoadNextPageIndicator(show: Boolean) {
        pb_news_more_loading.visibility = if (show) View.VISIBLE else View.GONE
    }

    override fun onItemClick(model: Article, view: View) {
        setFragmentResult(
            requestKey = Constants.KEY_REQUEST_TRANSFER_BETWEEN_FRAGMENT,
            result = bundleOf(Constants.KEY_BUNDLE_TRANSFER_BETWEEN_FRAGMENT to model)
        )
        presenter.openNewsDetails()
    }

    override fun onBottomReached(position: Int) {
        presenter.loadNextPage()
    }
}