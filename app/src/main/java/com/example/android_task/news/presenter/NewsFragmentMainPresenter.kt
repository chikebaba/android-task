package com.example.android_task.news.presenter

import androidx.room.Room
import com.example.android_task.news.model.*
import com.example.android_task.news.viewstate.NewsEvent
import com.example.android_task.news.viewstate.NewsViewState
import moxy.InjectViewState
import moxy.MvpPresenter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@InjectViewState
class NewsFragmentMainPresenter : MvpPresenter<NewsFragmentMainContract>() {

    val db = Room.databaseBuilder(
        applicationContext,
        NewsDatabase::class.java, "news-database"
    ).build()

    fun obtainEvent (event : NewsEvent) {
        when (event) {
            is NewsEvent.NewsFetch -> {
                getNews(callback: (List<News>) -> Unit)
                val newsDao = db.newsDao()
                newsDao.insertAll(List<News>)
                val news: List<NewsEntity> = newsDao.getAll()
            }
        }
    }

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