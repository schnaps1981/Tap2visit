package com.test.tap2visit.ui.fragments

import android.os.Bundle
import android.view.View
import com.test.tap2visit.R
import com.test.tap2visit.app.App
import com.test.tap2visit.mvp.presenters.NewsListPresenter
import com.test.tap2visit.mvp.views.NewsListView
import moxy.MvpAppCompatFragment
import moxy.presenter.InjectPresenter

class NewsListFragment : MvpAppCompatFragment(R.layout.news_list), NewsListView {

    @InjectPresenter
    lateinit var presenter: NewsListPresenter

    companion object{
        fun getInstance() : NewsListFragment = NewsListFragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        App.instance.inject(this)
    }
}