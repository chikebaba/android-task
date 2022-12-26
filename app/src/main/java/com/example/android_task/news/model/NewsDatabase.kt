package com.example.android_task.news.model

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [NewsEntity::class], version = 1)
abstract class NewsDatabase : RoomDatabase (){
    abstract fun newsDao () : NewsDAO
}