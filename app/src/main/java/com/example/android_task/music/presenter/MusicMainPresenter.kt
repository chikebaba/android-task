package com.example.android_task.music.presenter

import android.content.ContentResolver
import com.example.android_task.music.model.MusicProvider
import moxy.InjectViewState
import moxy.MvpPresenter
import moxy.MvpView


@InjectViewState
class MusicMainPresenter: MvpPresenter<MusicMainContract>() {

   /* override*/ fun loadSongsArtist(artist: String, musicArtistAdapter: MusicArtistAdapter, contentResolver : ContentResolver,itemsList : ArrayList<String>) {
        var rs = contentResolver.query(
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
        rs.let {
            if (rs!!.moveToFirst()) {
                do {
                    if (rs!!.getString(2) == artist)
                        itemsList.add(
                            rs!!.getString(1) + " " + rs!!.getString(2) + " " + rs!!.getString(
                                3
                            ) + " " + rs!!.getString(4)
                        )
                } while (rs!!.moveToNext())}
        }
        musicArtistAdapter.notifyDataSetChanged()
    }

    /*override*/ fun loadSongsGenre(genre: String, musicArtistAdapter: MusicArtistAdapter, contentResolver : ContentResolver,itemsList : ArrayList<String>) {
        var rs = contentResolver.query(
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
        rs.let {
            if (rs!!.moveToFirst()) {
                do {
                    if (rs!!.getString(3) == genre)
                        itemsList.add(
                            rs!!.getString(1) + " " + rs!!.getString(2) + " " + rs!!.getString(
                                3
                            ) + " " + rs!!.getString(4)
                        )
                } while (rs!!.moveToNext())}
        }
        musicArtistAdapter.notifyDataSetChanged()
    }
}