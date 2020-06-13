package com.test.tap2visit.global

import android.view.View

interface BaseAdapterCallback<T> {
    fun onItemClick(model: T, view: View)
    fun onLongClick(model: T, view: View) = true
    fun onBottomReached(position : Int)
}