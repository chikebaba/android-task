package com.example.android_task

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.view.View
import android.widget.*
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_music_artist.*

class MusicArtistActivity : AppCompatActivity() {

    private val itemsList = ArrayList<String>()
    private lateinit var musicArtistAdapter: MusicArtistAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var rs = contentResolver.query(
            MusicProvider.CONTENT_URI,
            arrayOf(MusicProvider._ID, MusicProvider.NAME, MusicProvider.ARTIST),
            null,
            null,
            null
        )

        setContentView(R.layout.activity_music_artist)
        val artists = resources.getStringArray(R.array.Artists)
        val songs = resources.getStringArray(R.array.Songs)
        val spinner_artist = findViewById<Spinner>(R.id.artist_spinner)

        val recyclerViewArtist = recyclerViewArtist as RecyclerView
        musicArtistAdapter = MusicArtistAdapter(itemsList)
        val layoutManager = LinearLayoutManager(this)
        recyclerViewArtist.layoutManager = layoutManager
        recyclerViewArtist.adapter = musicArtistAdapter

        if (spinner_artist != null) {
            val adapter = ArrayAdapter(
                this,
                android.R.layout.simple_spinner_item, artists
            )
            spinner_artist.adapter = adapter

            spinner_artist.onItemSelectedListener = object :
                AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>,
                    view: View, position: Int, id: Long
                ) {
                    Toast.makeText(
                        this@MusicArtistActivity,
                        "Selected item" + " " +
                                "" + artists[position], Toast.LENGTH_SHORT
                    ).show()
                    itemsList.clear()
                    loadSongsArtist(artists[position])

                }

                override fun onNothingSelected(parent: AdapterView<*>) {

                }
            }
        }

        val spinner_genre = findViewById<Spinner>(R.id.genre_spinner)
        if (spinner_genre != null) {
            val adapter = ArrayAdapter(
                this,
                android.R.layout.simple_spinner_item, songs
            )
            spinner_genre.adapter = adapter
            spinner_genre.onItemSelectedListener = object :
                AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>,
                    view: View, position: Int, id: Long
                ) {
                    Toast.makeText(
                        this@MusicArtistActivity,
                        "Selected item" + " " +
                                "" + songs[position], Toast.LENGTH_SHORT
                    ).show()
                    itemsList.clear()
                    loadSongsGenre(songs[position])
                }

                override fun onNothingSelected(parent: AdapterView<*>) {
                }
            }
        }
    }

    private fun loadSongsArtist(artist: String) {
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

    private fun loadSongsGenre(genre: String) {
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


