package com.example.android_task.music.view

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import com.example.android_task.R
import com.example.android_task.databinding.ActivityMusicMainBinding


class MusicMainActivity : AppCompatActivity() {
    var mMediaPlayer: MediaPlayer? = null
    private val receiver = MusicReceiver()
    private lateinit var binding : ActivityMusicMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMusicMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val intentFilter = IntentFilter(resources.getString(R.string.action_br_receiver))
        intentFilter.addAction(resources.getString(R.string.action_br_receiver))
        LocalBroadcastManager.getInstance(this).registerReceiver(receiver, intentFilter)

        val button_artist = binding.buttonArtist
        button_artist.setOnClickListener {
            val intent = Intent(this, MusicArtistActivity::class.java)
            startActivity(intent)
        }

        val textViewSongName: TextView = binding.textViewSongName
        val textViewGenre: TextView = binding.textViewGenre
        val textViewArtist: TextView = binding.textViewArtist

        val button_play = binding.buttonPlay

        val songName = intent?.getStringExtra("songName")
        val songArtist = intent?.getStringExtra("songArtist")
        val songGenre = intent?.getStringExtra("songGenre")
        val songPath = intent?.getStringExtra("songPath")

        textViewSongName.setText("Name: " + songName)
        textViewGenre.setText("Genre: " + songGenre)
        textViewArtist.setText("Artist: " + songArtist)
        button_play.setOnClickListener { playSound(songPath.toString()) }

    }

    fun playSound(songPath: String?) {
        val resID = getResources().getIdentifier(songPath, "raw", packageName)
        if (mMediaPlayer == null) {
            mMediaPlayer = MediaPlayer.create(this, resID)
            mMediaPlayer!!.isLooping = true
            mMediaPlayer!!.start()
        } else mMediaPlayer!!.start()
    }

    fun pauseSound(view: View) {
        if (mMediaPlayer?.isPlaying == true) mMediaPlayer?.pause()
    }

    fun stopSound(view: View) {
        if (mMediaPlayer != null) {
            mMediaPlayer!!.stop()
            mMediaPlayer!!.release()
            mMediaPlayer = null
        }
    }

    inner class MusicReceiver : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            var songName = intent?.getStringExtra("song")
        }
    }
}
