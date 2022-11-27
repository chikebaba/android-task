package com.example.android_task.news.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_news.*
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.android_task.news.presenter.NewsRecyclerViewAdapter
import com.example.android_task.R
import com.example.android_task.news.model.News
import com.example.android_task.news.model.NewsApiInterface
import com.example.android_task.news.model.NewsApiService
import com.example.android_task.news.model.NewsResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewsFragment : Fragment() {

    private var itemsList = ArrayList<String>()
    private lateinit var newsRecyclerViewAdapter: NewsRecyclerViewAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_news, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        news_recyclerview.layoutManager = LinearLayoutManager(this@NewsFragment.context)
        news_recyclerview.setHasFixedSize(true)
        val newsThemes = resources.getStringArray(R.array.NewsThemes)
        val news_theme_spinner = news_theme_spinner
        if (news_theme_spinner != null) {
            val adapter = this@NewsFragment.context?.let {
                ArrayAdapter(
                    it,
                    android.R.layout.simple_spinner_item, newsThemes
                )
            }
            news_theme_spinner.adapter = adapter
            news_theme_spinner.onItemSelectedListener = object :
                AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>,
                    view: View, position: Int, id: Long
                ) {
                    Toast.makeText(
                        this@NewsFragment.context,
                        "Selected item" + " " +
                                "" + newsThemes[position], Toast.LENGTH_SHORT
                    ).show()
                    itemsList.clear()

                    when (newsThemes[position]) {

                        "software" -> getNews { news: List<News> ->
                            news_recyclerview.adapter = NewsRecyclerViewAdapter(news)
                        }

                        "film" -> getNewsFilm { news: List<News> ->
                            news_recyclerview.adapter = NewsRecyclerViewAdapter(news)
                        }

                        "music" -> getNewsMusic { news: List<News> ->
                            news_recyclerview.adapter = NewsRecyclerViewAdapter(news)
                        }

                        "science" -> getNewsScience { news: List<News> ->
                            news_recyclerview.adapter = NewsRecyclerViewAdapter(news)
                        }

                        "general" -> getNewsSoftware { news: List<News> ->
                            news_recyclerview.adapter = NewsRecyclerViewAdapter(news)
                        }

                        else -> {
                        }
                    }
                }

                override fun onNothingSelected(parent: AdapterView<*>) {
                }
            }
        }
    }


    private fun getNews(callback: (List<News>) -> Unit) {
        val apiService = NewsApiService.getInstance().create(NewsApiInterface::class.java)
        apiService.getNews().enqueue(object : Callback<NewsResponse> {
            override fun onFailure(call: Call<NewsResponse>, t: Throwable) {
            }

            override fun onResponse(call: Call<NewsResponse>, response: Response<NewsResponse>) {
                return callback(response.body()!!.news)
            }
        })
    }

    private fun getNewsMusic(callback: (List<News>) -> Unit) {
        val apiService = NewsApiService.getInstance().create(NewsApiInterface::class.java)
        apiService.getNewsMusic().enqueue(object : Callback<NewsResponse> {
            override fun onFailure(call: Call<NewsResponse>, t: Throwable) {
            }

            override fun onResponse(call: Call<NewsResponse>, response: Response<NewsResponse>) {
                return callback(response.body()!!.news)
            }
        })
    }

    private fun getNewsSoftware(callback: (List<News>) -> Unit) {
        val apiService = NewsApiService.getInstance().create(NewsApiInterface::class.java)
        apiService.getNewsSoftware().enqueue(object : Callback<NewsResponse> {
            override fun onFailure(call: Call<NewsResponse>, t: Throwable) {
            }

            override fun onResponse(call: Call<NewsResponse>, response: Response<NewsResponse>) {
                return callback(response.body()!!.news)
            }
        })
    }

    private fun getNewsFilm(callback: (List<News>) -> Unit) {
        val apiService = NewsApiService.getInstance().create(NewsApiInterface::class.java)
        apiService.getNewsFilm().enqueue(object : Callback<NewsResponse> {
            override fun onFailure(call: Call<NewsResponse>, t: Throwable) {
            }

            override fun onResponse(call: Call<NewsResponse>, response: Response<NewsResponse>) {
                return callback(response.body()!!.news)
            }
        })
    }

    private fun getNewsScience(callback: (List<News>) -> Unit) {
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