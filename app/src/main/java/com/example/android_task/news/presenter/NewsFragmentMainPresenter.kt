package com.example.android_task.news.presenter

import com.example.android_task.news.model.News
import com.example.android_task.news.model.NewsApiInterface
import com.example.android_task.news.model.NewsApiService
import com.example.android_task.news.model.NewsResponse
import moxy.InjectViewState
import moxy.MvpPresenter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@InjectViewState
class NewsFragmentMainPresenter : MvpPresenter<NewsFragmentMainContract>() {
    /*override*/ fun getNews(callback: (List<News>) -> Unit) {
        val apiService = NewsApiService.getInstance().create(NewsApiInterface::class.java)
        apiService.getNews().enqueue(object : Callback<NewsResponse> {
            override fun onFailure(call: Call<NewsResponse>, t: Throwable) {
            }

            override fun onResponse(call: Call<NewsResponse>, response: Response<NewsResponse>) {
                return callback(response.body()!!.news)
            }
        })
    }

    /*override*/ fun getNewsMusic(callback: (List<News>) -> Unit) {
        val apiService = NewsApiService.getInstance().create(NewsApiInterface::class.java)
        apiService.getNewsMusic().enqueue(object : Callback<NewsResponse> {
            override fun onFailure(call: Call<NewsResponse>, t: Throwable) {
            }

            override fun onResponse(call: Call<NewsResponse>, response: Response<NewsResponse>) {
                return callback(response.body()!!.news)
            }
        })
    }

    /*override */fun getNewsSoftware(callback: (List<News>) -> Unit) {
        val apiService = NewsApiService.getInstance().create(NewsApiInterface::class.java)
        apiService.getNewsSoftware().enqueue(object : Callback<NewsResponse> {
            override fun onFailure(call: Call<NewsResponse>, t: Throwable) {
            }

            override fun onResponse(call: Call<NewsResponse>, response: Response<NewsResponse>) {
                return callback(response.body()!!.news)
            }
        })
    }

    /*override*/ fun getNewsFilm(callback: (List<News>) -> Unit) {
        val apiService = NewsApiService.getInstance().create(NewsApiInterface::class.java)
        apiService.getNewsFilm().enqueue(object : Callback<NewsResponse> {
            override fun onFailure(call: Call<NewsResponse>, t: Throwable) {
            }

            override fun onResponse(call: Call<NewsResponse>, response: Response<NewsResponse>) {
                return callback(response.body()!!.news)
            }
        })
    }

    /*override*/ fun getNewsScience(callback: (List<News>) -> Unit) {
        val apiService = NewsApiService.getInstance().create(NewsApiInterface::class.java)
        apiService.getNewsScience().enqueue(object : Callback<NewsResponse> {
            override fun onFailure(call: Call<NewsResponse>, t: Throwable) {
            }

            override fun onResponse(call: Call<NewsResponse>, response: Response<NewsResponse>) {
                return callback(response.body()!!.news)
            }
        })
    }
}