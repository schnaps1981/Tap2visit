package com.test.tap2visit.ui.fragments

import android.os.Bundle
import android.view.View
import com.test.tap2visit.R
import com.test.tap2visit.app.App
import com.test.tap2visit.mvp.presenters.NewsListFragmentPresenter
import com.test.tap2visit.mvp.views.NewsListFragmentView
import moxy.MvpAppCompatFragment
import moxy.MvpView
import moxy.presenter.InjectPresenter

class NewsListFragment : MvpAppCompatFragment(R.layout.news_list), NewsListFragmentView {

    @InjectPresenter
    lateinit var presenter: NewsListFragmentPresenter

    companion object{
        fun getInstance() : NewsListFragment = NewsListFragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        App.instance.inject(this)
    }
}