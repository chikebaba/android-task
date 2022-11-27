package com.example.android_task.news.model

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NewsApiService {

    companion object {
        private const val BASE_URL = "https://newsapi.org/"
        private var retrofit: Retrofit? = null

        fun getInstance(): Retrofit {
            if (retrofit == null) {
                retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return retrofit!!
        }
    }
}
