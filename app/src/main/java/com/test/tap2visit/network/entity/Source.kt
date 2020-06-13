package com.test.tap2visit.network.entity

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import kotlinx.android.parcel.RawValue

@Parcelize
data class Source (
    val id: @RawValue Any,
    val name: String
) : Parcelable
