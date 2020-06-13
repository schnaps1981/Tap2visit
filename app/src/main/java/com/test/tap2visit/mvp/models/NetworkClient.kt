package com.test.tap2visit.mvp.models

import com.test.tap2visit.app.App
import com.test.tap2visit.network.api.ApiInterface
import com.test.tap2visit.network.entity.Article
import com.test.tap2visit.network.entity.Categories
import com.test.tap2visit.network.entity.NewsItems
import io.reactivex.Single
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class NetworkClient @Inject constructor(val api: ApiInterface) {

    init {
        App.instance.inject(this)
    }

    fun recieveNews(category: Categories, page: Int) = Single.create<List<Article>> { emitter ->
        api.getData(page = page, category = category.categoryName).enqueue(object : Callback<NewsItems> {
            override fun onFailure(call: Call<NewsItems>, t: Throwable) {
                emitter.onError(t)
            }

            override fun onResponse(call: Call<NewsItems>, response: Response<NewsItems>) {
                if (response.isSuccessful)
                    response.body()?.articles?.toList()?.let { emitter.onSuccess(it) }
            }
        })
    }


}