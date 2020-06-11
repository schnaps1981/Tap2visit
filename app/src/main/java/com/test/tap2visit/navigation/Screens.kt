package com.test.tap2visit.navigation

import androidx.fragment.app.Fragment
import com.test.tap2visit.ui.fragments.NewsDetailFragment
import com.test.tap2visit.ui.fragments.NewsListFragment
import ru.terrakok.cicerone.android.support.SupportAppScreen

object Screens {
    class NewsListNav : SupportAppScreen() {
        override fun getFragment() = NewsListFragment.getInstance()
    }

    class NewsDetailNav : SupportAppScreen() {
        override fun getFragment() = NewsDetailFragment.getInstance()
    }
}