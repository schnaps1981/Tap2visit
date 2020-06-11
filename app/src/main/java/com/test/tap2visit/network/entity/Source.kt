package com.test.tap2visit.network.api.entity

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

data class Source (
    @SerializedName("id") val id : String?,
    @SerializedName("name") val name : String?
)
