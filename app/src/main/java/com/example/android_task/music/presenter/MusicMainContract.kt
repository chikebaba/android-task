package com.example.android_task.music.presenter

import android.content.ContentResolver
import moxy.MvpView
import moxy.viewstate.strategy.AddToEndStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(value= AddToEndStrategy::class)
interface MusicMainContract : MvpView {
    fun loadSongsArtist(artist: String, musicArtistAdapter : MusicArtistAdapter, contentResolver : ContentResolver, itemsList : ArrayList<String>)
    fun loadSongsGenre(genre: String, musicArtistAdapter : MusicArtistAdapter, contentResolver : ContentResolver, itemsList : ArrayList<String> )
}