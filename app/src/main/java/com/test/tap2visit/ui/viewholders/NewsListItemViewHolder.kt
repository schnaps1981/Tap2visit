package com.test.tap2visit.ui.viewholders

import android.view.View
import android.view.ViewGroup
import android.view.ViewParent
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.squareup.picasso.MemoryPolicy
import com.squareup.picasso.NetworkPolicy
import com.squareup.picasso.Picasso
import com.test.tap2visit.global.BaseViewHolder
import com.test.tap2visit.global.toHumanTime
import com.test.tap2visit.network.entity.Article
import kotlinx.android.synthetic.main.news_item.view.*

class NewsListItemViewHolder(itemView: View, private val parent: ViewGroup) : BaseViewHolder<Article>(itemView = itemView) {
    override fun bind(model: Article) {

        val circularProgressDrawable = CircularProgressDrawable(parent.context)
        circularProgressDrawable.strokeWidth = 5f
        circularProgressDrawable.centerRadius = 30f
        circularProgressDrawable.start()

        with(itemView)
        {
            tv_author.text = model.author
            tv_news_description.text = model.description
            tv_news_title.text = model.title
            tv_published_at.text = model.publishedAt.toHumanTime()
            tv_source.text = model.source.name

            Picasso.get()
                .load(model.urlToImage)
                .placeholder(circularProgressDrawable)
                .networkPolicy(NetworkPolicy.OFFLINE)
                .into(iv_news_image)
        }
    }
}