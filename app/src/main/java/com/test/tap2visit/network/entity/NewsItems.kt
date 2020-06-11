package com.test.tap2visit.network.api.entity

import com.google.gson.annotations.SerializedName
import com.test.tap2visit.network.api.entity.Article

data class NewsItems(
    @SerializedName("status") val status: String,
    @SerializedName("totalResults") val totalResults: Int,
    @SerializedName("articles") val articles: ArrayList<Article>?
)