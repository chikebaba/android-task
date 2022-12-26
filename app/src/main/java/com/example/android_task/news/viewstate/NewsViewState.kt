package com.example.android_task.news.viewstate

import com.example.android_task.news.model.News

sealed class NewsViewState {
    object NewsLoadingState : NewsViewState ()
    object NewsNoItemsState : NewsViewState ()
    class NewsLoadedState (val news : List<News>) : NewsViewState ()
    class NewsErrorState (val message: String ) : NewsViewState ()
}
sealed class NewsEvent {
    object NewsFetch : NewsEvent ()
}

class NewsSimpleViewState (val news : List<News>?,val message: String?, val isLoading: Boolean)