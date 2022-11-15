package com.example.android_task

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.news_item.view.*

class NewsRecyclerViewAdapter(private val news: List<News>) :
    RecyclerView.Adapter<NewsRecyclerViewAdapter.NewsViewHolder>() {
    class NewsViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bindNews(news: News) {
            itemView.itemTextViewNews.text = "Go to article"
            itemView.textViewNewsAuthor.text = "Author: " + news.author
            itemView.textViewNewsTitle.text = "Title: " + news.title
            itemView.textViewNewsPublishedAt.text = "Published: " + news.publishedAt
            itemView.textViewNewsDescription.text = news.description
            val IMAGE_BASE = news.urlToImage
            Glide.with(itemView).load(IMAGE_BASE).into(itemView.imageNews)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        return NewsViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.news_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.bindNews(news.get(position))

        holder.itemView.itemTextViewNews.setOnClickListener {
            val context = holder.itemView.context

            val bundle = Bundle()
            bundle.putString("image", news[position].urlToImage)
            bundle.putString("description", news[position].description)
            bundle.putString("title", news[position].title)
            bundle.putString("publishedAt", news[position].publishedAt)
            bundle.putString("author", news[position].author)

            val fragInfo = DetailedNewsDescriptionFragment()
            fragInfo.arguments = bundle;

            val transaction =
                (context as AppCompatActivity).supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_container, fragInfo)
            transaction.addToBackStack(null)
            transaction.commit()

        }

    }

    override fun getItemCount(): Int = news.size
}