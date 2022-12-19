package com.example.android_task

import android.content.ContentResolver
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import androidx.test.InstrumentationRegistry.getContext
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.android_task.music.model.MusicHelper
import com.example.android_task.music.model.MusicProvider
import org.hamcrest.core.IsEqual.equalTo
import org.junit.After
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertThat
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException

@RunWith(AndroidJUnit4::class)
class DataBaseTest {

    private lateinit var db: SQLiteDatabase

    @Before
    fun createDb() {
        var helper = MusicHelper(getContext())
        db = helper.writableDatabase
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        db.close()
    }

    @Test
    @Throws(Exception::class)
    fun writeAndReadSong() {
        db!!.execSQL("DROP TABLE IF EXISTS MUSICTABLE");
        db!!.execSQL("CREATE TABLE MUSICTABLE")
        db?.execSQL("INSERT INTO MUSICTABLE(NAME,ARTIST,GENRE,PATH) VALUES('code_of_conduct','zimmer','epic','hans_zimmer_code_of_conduct')")

       var contentResolver : ContentResolver
       contentResolver = helper.getContentResolver()

        val testQuery = contentResolver.query(
            MusicProvider.CONTENT_URI,
            arrayOf(
                MusicProvider._ID,
                MusicProvider.NAME,
                MusicProvider.ARTIST,
                MusicProvider.GENRE,
                MusicProvider.PATH
            ),
            null,
            null,
            null
        )
        assertNotNull(testQuery)
        assertThat(testQuery.toString(), equalTo("'code_of_conduct','zimmer','epic','hans_zimmer_code_of_conduct'"))
    }
}