package com.example.android_task.firsttask.view

import android.app.AlertDialog
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView
import com.example.android_task.R

internal class CustomAdapter(private var itemsList: List<String>) : RecyclerView.Adapter<CustomAdapter.MyViewHolder>() {
    internal inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var itemTextView: TextView = view.findViewById(R.id.itemTextView)
    }

    @NonNull
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = itemsList[position]
        holder.itemTextView.text = item
        holder.itemTextView.setOnClickListener {
            val builder = AlertDialog.Builder(it.context)

            with(builder)
            {
                setTitle("Picked item")
                setMessage("Item " + itemsList[position])
                show()
            }
        }
    }

    override fun getItemCount(): Int {
        return itemsList.size
    }
}
