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
import kotlinx.android.synthetic.main.activity_music_main.*


class MusicMainActivity : AppCompatActivity() {
    var mMediaPlayer: MediaPlayer? = null
    private val receiver = MusicReceiver()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_music_main)

        val intentFilter = IntentFilter("PICK_MUSIC")
        intentFilter.addAction("PICK_MUSIC")
        LocalBroadcastManager.getInstance(this).registerReceiver(receiver, intentFilter)

        val button_artist = findViewById<Button>(R.id.button_artist)
        button_artist.setOnClickListener {
            val intent = Intent(this, MusicArtistActivity::class.java)
            startActivity(intent)
        }

        val textView10: TextView = findViewById<TextView>(R.id.textView10)
        val textView11: TextView = findViewById<TextView>(R.id.textView11)
        val textView12: TextView = findViewById<TextView>(R.id.textView12)

        val songName = intent?.getStringExtra("songName")
        val songArtist = intent?.getStringExtra("songArtist")
        val songGenre = intent?.getStringExtra("songGenre")
        val songPath = intent?.getStringExtra("songPath")

        textView10.setText("Name: " + songName)
        textView11.setText("Genre: " + songGenre)
        textView12.setText("Artist: " + songArtist)
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