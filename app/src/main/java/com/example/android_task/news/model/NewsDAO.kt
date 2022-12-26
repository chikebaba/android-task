package com.example.android_task.news.model

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface NewsDAO {
    @Query("SELECT * FROM newsEntity")
    fun getAll(): List<NewsEntity>

    @Query("SELECT * FROM newsEntity WHERE uid IN (:userIds)")
    fun loadAllByIds(userIds: IntArray): List<NewsEntity>

    @Query("SELECT * FROM newsEntity WHERE author LIKE :first AND " +
            "title LIKE :last LIMIT 10")
    fun findByName(first: String, last: String): NewsEntity

    @Insert
    fun insertAll(vararg newsEntity: NewsEntity)

    @Delete
    fun delete(newsEntity: NewsEntity)
}