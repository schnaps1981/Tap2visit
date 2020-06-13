package com.test.tap2visit.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.test.tap2visit.R
import com.test.tap2visit.global.BaseAdapter
import com.test.tap2visit.global.BaseViewHolder
import com.test.tap2visit.network.entity.Article
import com.test.tap2visit.ui.viewholders.NewsListItemViewHolder

class NewsListAdapter : BaseAdapter<Article>() {
    private lateinit var newsItemViewHolder: NewsListItemViewHolder

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<Article> {
        newsItemViewHolder = NewsListItemViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.news_item, parent, false), parent)
        return this.newsItemViewHolder
    }
}