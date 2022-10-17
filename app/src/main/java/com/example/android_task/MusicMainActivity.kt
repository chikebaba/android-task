package com.example.android_task

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import com.example.android_task.databinding.ActivityMusicMainBinding
import kotlinx.android.synthetic.main.activity_music_main.*

class MusicMainActivity : AppCompatActivity() {
    var mMediaPlayer: MediaPlayer? = null
    private val receiver = MusicReceiver()
    private lateinit var binding : ActivityMusicMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMusicMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val intentFilter = IntentFilter("PICK_MUSIC")
        intentFilter.addAction("PICK_MUSIC")
        LocalBroadcastManager.getInstance(this).registerReceiver(receiver, intentFilter)

        val button_artist = binding.buttonArtist
        button_artist.setOnClickListener {
            val intent = Intent(this, MusicArtistActivity::class.java)
            startActivity(intent)
        }

        val textViewSongName: TextView = findViewById<TextView>(R.id.textViewSongName)
        val textViewGenre: TextView = findViewById<TextView>(R.id.textViewGenre)
        val textViewArtist: TextView = findViewById<TextView>(R.id.textViewArtist)

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
            textView11.setText(songName)
        }
    }
}
