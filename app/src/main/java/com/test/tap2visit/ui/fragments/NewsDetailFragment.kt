package com.test.tap2visit.ui.fragments

import android.os.Bundle
import android.view.View
import android.webkit.DownloadListener
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.setFragmentResultListener
import com.test.tap2visit.R
import com.test.tap2visit.app.App
import com.test.tap2visit.app.Constants
import com.test.tap2visit.mvp.presenters.NewsDetailPresenter
import com.test.tap2visit.mvp.views.NewsDetailsView
import com.test.tap2visit.network.entity.Article
import kotlinx.android.synthetic.main.news_deatails.*
import moxy.MvpAppCompatFragment
import moxy.presenter.InjectPresenter
import timber.log.Timber
import javax.inject.Inject

class NewsDetailFragment : MvpAppCompatFragment(R.layout.news_deatails), NewsDetailsView {

    @InjectPresenter
    lateinit var presenter: NewsDetailPresenter

    companion object{
        fun getInstance() : NewsDetailFragment = NewsDetailFragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        App.instance.inject(this)

        setFragmentResultListener(requestKey = Constants.KEY_REQUEST_TRANSFER_BETWEEN_FRAGMENT) { _, bundle ->
            val result = bundle.getParcelable<Article>(Constants.KEY_BUNDLE_TRANSFER_BETWEEN_FRAGMENT)
            ww_news_detail.loadUrl(result?.url)
        }
    }
}