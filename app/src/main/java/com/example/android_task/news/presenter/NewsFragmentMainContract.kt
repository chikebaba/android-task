package com.example.android_task.news.presenter

import com.example.android_task.news.model.News
import moxy.MvpView
import moxy.viewstate.strategy.AddToEndStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(value= AddToEndStrategy::class)
interface NewsFragmentMainContract : MvpView {
     fun getNews(callback: (List<News>) -> Unit)
     fun getNewsMusic(callback: (List<News>) -> Unit)
     fun getNewsSoftware(callback: (List<News>) -> Unit)
     fun getNewsFilm(callback: (List<News>) -> Unit)
     fun getNewsScience(callback: (List<News>) -> Unit)
}