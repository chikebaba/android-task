package com.example.android_task.news.model

import android.os.Parcelable
import com.github.pozo.KotlinBuilder
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class News(

    @SerializedName("author")
    val author: String?,

    @SerializedName("title")
    val title: String?,

    @SerializedName("description")
    val description: String?,

    @SerializedName("urlToImage")
    val urlToImage: String?,

    @SerializedName("publishedAt")
    val publishedAt: String?

) : Parcelable {
     object NewsMapper {
            fun from(newsResponse : NewsResponse, position : Int) =
                News(newsResponse.news[position].author,newsResponse.news[position].title,newsResponse.news[position].description,newsResponse.news[position].urlToImage,newsResponse.news[position].publishedAt)
        }
}
