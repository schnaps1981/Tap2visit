package com.test.tap2visit.network.api

import com.test.tap2visit.app.Constants
import com.test.tap2visit.network.entity.NewsItems
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {
    @GET("/v2/top-headlines")
    fun getData(
        @Query("country") country: String = Constants.API_DEFAULT_COUNTRY,
        @Query("category") category: String? = null,
        @Query("pageSize") pageSize: Int = Constants.API_DEFAULT_PAGE_SIZE,
        @Query("page") page: Int = Constants.API_PAGE,
        @Query("apiKey") apiKey: String = Constants.API_KEY
    ): Call<NewsItems>

}