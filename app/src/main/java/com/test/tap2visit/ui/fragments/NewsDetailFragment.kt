package com.test.tap2visit.ui.fragments

import android.os.Bundle
import android.view.View
import com.test.tap2visit.R
import com.test.tap2visit.app.App
import com.test.tap2visit.mvp.presenters.NewsDetailPresenter
import com.test.tap2visit.mvp.views.NewsDetailsView
import kotlinx.android.synthetic.main.news_deatails.view.*
import moxy.MvpAppCompatFragment
import moxy.presenter.InjectPresenter

class NewsDetailFragment : MvpAppCompatFragment(R.layout.news_deatails), NewsDetailsView {

    @InjectPresenter
    lateinit var presenter: NewsDetailPresenter

    companion object{
        fun getInstance() : NewsDetailFragment = NewsDetailFragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        App.instance.inject(this)
    }
}