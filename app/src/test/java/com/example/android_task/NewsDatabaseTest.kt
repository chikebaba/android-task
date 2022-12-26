package com.example.android_task

import android.content.ContentResolver
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import androidx.room.Room
import androidx.test.InstrumentationRegistry.getContext
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.android_task.music.model.MusicHelper
import com.example.android_task.music.model.MusicProvider
import com.example.android_task.news.model.News
import com.example.android_task.news.model.NewsDAO
import com.example.android_task.news.model.NewsDatabase
import com.example.android_task.news.model.NewsEntity
import kotlinx.coroutines.runBlocking
import org.hamcrest.core.IsEqual.equalTo
import org.junit.After
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertThat
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException

@RunWith(AndroidJUnit4::class)
class NewsDatabaseTest {

    private lateinit var db: NewsDatabase
    private lateinit var dao: NewsDAO

    @Before
    fun setUp () {
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(context, NewsDatabase::class.java).build()
        dao = db.newsDao().getAll()
    }

    @After
    fun closeDb() {
        db.close()
    }

    @Test
    fun writeAndReadNews () = runBlocking {
        val newsForInput = NewsEntity (0,"James Barton","Arctic freeze continues to grip much of North America.","The worst-hit area has been Buffalo, in upstate New York, where seven weather-related","https://www.bbc.com/news/science-environment-64051171","25-12-2022")
        dao.insertAll(newsForInput)
        val newsForTest = dao.getAll()
        assertThat(newsForInput, equalTo(newsForTest))
    }
}