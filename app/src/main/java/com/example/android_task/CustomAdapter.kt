package com.example.android_task

import android.app.AlertDialog
import android.content.DialogInterface
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView

internal class CustomAdapter(private var itemsList: List<String>) :
    RecyclerView.Adapter<CustomAdapter.MyViewHolder>() {
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

        //  holder.itemTextView.setText(itemsList.get(position))

        holder.itemTextView.setOnClickListener {    /* (holder.itemTextView.setTextColor(Color.GREEN)) */



            val builder = AlertDialog.Builder(it.context)

            /*  val positiveButtonClick = { dialog: DialogInterface, which: Int ->
                  Toast.makeText(applicationContext,
                      android.R.string.yes, Toast.LENGTH_SHORT).show()
              }*/

            with(builder)
            {
                setTitle("Picked item")
                setMessage("Item " + itemsList[position] )
                //  setPositiveButton("OK", DialogInterface.OnClickListener(function = positiveButtonClick))
                //  setNegativeButton(android.R.string.no, negativeButtonClick)
                //   setNeutralButton("Maybe", neutralButtonClick)
                show()
            }


        } // click event



    }



    override fun getItemCount(): Int {
        return itemsList.size
    }


}