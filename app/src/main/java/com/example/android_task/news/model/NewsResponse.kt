package com.example.android_task.news.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class NewsResponse(
    @SerializedName("articles")
    val news: List<News>

) : Parcelable {
    constructor() : this(mutableListOf())
}