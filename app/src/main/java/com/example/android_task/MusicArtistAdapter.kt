package com.example.android_task

import android.app.AlertDialog
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView

internal class MusicArtistAdapter(private var itemsList: List<String>) :
    RecyclerView.Adapter<MusicArtistAdapter.MyViewHolder>() {
    internal inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var itemTextViewSong: TextView = view.findViewById(R.id.itemTextViewSong)
    }
    
    companion object {
        val intentBr = Intent("PICK_MUSIC")
    }

    @NonNull
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MusicArtistAdapter.MyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.song_item, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MusicArtistAdapter.MyViewHolder, position: Int) {
        val item = itemsList[position]
        holder.itemTextViewSong.text = item
        holder.itemTextViewSong.setOnClickListener {
            val builder = AlertDialog.Builder(it.context)
            with(builder)
            {
                setTitle("Picked item")
                setMessage("Item " + itemsList[position])
                show()
            }

            val context = holder.itemTextViewSong.context
            val intent = Intent(context, MusicMainActivity::class.java)
            val arr = itemsList[position].split(" ")
            intent.apply {
                putExtra("song", itemsList[position])
                putExtra("songPath", arr.get(3))
                putExtra("songGenre", arr.get(2))
                putExtra("songArtist", arr.get(1))
                putExtra("songName", arr.get(0))
            }

           
            intentBr.setAction("PICK_MUSIC")
            context.sendBroadcast(intentBr)

            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return itemsList.size
    }
}
