package com.test.tap2visit.mvp.models

import android.util.Log
import com.test.tap2visit.app.App
import com.test.tap2visit.app.Constants
import com.test.tap2visit.network.api.ApiInterface
import com.test.tap2visit.network.entity.Categories
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import timber.log.Timber
import javax.inject.Inject

class RecieveNews {

    @Inject
    lateinit var api: ApiInterface

    init {
        App.instance.inject(this)
    }

    fun test(category : Categories) {
        api
            .getData(category = category.categoryName)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                Timber.d(it.articles?.size.toString())
            }
    }


}