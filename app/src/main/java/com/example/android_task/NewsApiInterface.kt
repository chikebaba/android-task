package com.example.android_task

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface NewsApiInterface {
    @GET("/v2/everything?q=tesla&from=2022-10-07&sortBy=publishedAt&apiKey=841fdcee6637468ba090bf99257ca12e")
    fun getNews() : Call<NewsResponse>

    @GET("/v2/everything?q=apple&from=2022-11-06&to=2022-11-06&sortBy=popularity&apiKey=841fdcee6637468ba090bf99257ca12e")
    fun getNewsSoftware() : Call<NewsResponse>

    @GET("/v2/top-headlines?sources=techcrunch&apiKey=841fdcee6637468ba090bf99257ca12e")
    fun getNewsScience() : Call<NewsResponse>

    @GET("/v2/top-headlines?country=us&category=business&apiKey=841fdcee6637468ba090bf99257ca12e")
    fun getNewsMusic() : Call<NewsResponse>

    @GET("/v2/everything?domains=wsj.com&apiKey=841fdcee6637468ba090bf99257ca12e")
    fun getNewsFilm() : Call<NewsResponse>
}