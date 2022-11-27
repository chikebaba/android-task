package com.example.android_task.news.model

import retrofit2.Call
import retrofit2.http.GET

interface NewsApiInterface {
    @GET("/v2/everything?q=tesla&from=2022-10-07&sortBy=publishedAt&apiKey=")
    fun getNews() : Call<NewsResponse>

    @GET("/v2/everything?q=apple&from=2022-11-06&to=2022-11-06&sortBy=popularity&apiKey=")
    fun getNewsSoftware() : Call<NewsResponse>

    @GET("/v2/top-headlines?sources=techcrunch&apiKey=")
    fun getNewsScience() : Call<NewsResponse>

    @GET("/v2/top-headlines?country=us&category=business&apiKey=")
    fun getNewsMusic() : Call<NewsResponse>

    @GET("/v2/everything?domains=wsj.com&apiKey=")
    fun getNewsFilm() : Call<NewsResponse>
}
