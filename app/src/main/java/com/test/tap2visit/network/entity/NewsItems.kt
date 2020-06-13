package com.test.tap2visit.network.entity

import com.google.gson.annotations.SerializedName
import com.test.tap2visit.network.entity.Article

data class NewsItems(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)