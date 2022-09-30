package com.example.android_task

import android.content.ContentProvider
import android.content.ContentValues
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.net.Uri


class MusicProvider : ContentProvider() {
    companion object {
        val PROVIDER_NAME = "com.example.android_task/MusicProvider"
        val URL = "content://$PROVIDER_NAME/MUSICTABLE"
        val CONTENT_URI = Uri.parse(URL)

        val _ID = "_id"
        val NAME = "NAME"
        val ARTIST = "ARTIST"
        val GENRE = "GENRE"
        val PATH = "PATH"
    }

    lateinit var db: SQLiteDatabase


    override fun onCreate(): Boolean {
        var helper = MusicHelper(getContext())
        db = helper.writableDatabase
        return if (db == null) false else true
    }

    override fun query(
        uri: Uri,
        cols: Array<out String>?,
        condition: String?,
        condition_val: Array<out String>?,
        order: String?
    ): Cursor? {
        return db.query("MUSICTABLE", cols, condition, condition_val, null, null, order)
    }

    override fun getType(p0: Uri): String? {
        return "vnd.android.cursor.dir/vnd.example.musictable"
    }

    override fun insert(uri: Uri, cv: ContentValues?): Uri? {
        db.insert("MUSICTABLE", null, cv)
        context?.contentResolver?.notifyChange(uri, null)
        return uri
    }

    override fun delete(uri: Uri, condition: String?, condition_val: Array<out String>?): Int {
        var count = db.delete("MUSICTABLE", condition, condition_val)
        context?.contentResolver?.notifyChange(uri, null)
        return count
    }

    override fun update(
        uri: Uri,
        cv: ContentValues?,
        condition: String?,
        condition_val: Array<out String>?
    ): Int {
        var count = db.update("MUSICTABLE", cv, condition, condition_val)
        context?.contentResolver?.notifyChange(uri, null)
        return count
    }
}

