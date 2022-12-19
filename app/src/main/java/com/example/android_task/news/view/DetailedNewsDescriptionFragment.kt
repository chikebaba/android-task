package com.example.android_task.news.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.android_task.R
import kotlinx.android.synthetic.main.fragment_detailed_news_description.*

class DetailedNewsDescriptionFragment : Fragment(R.layout.fragment_detailed_news_description) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val textViewNewsDetailedAuthor = textViewNewsDetailedAuthor
        val textViewNewsDetailedDescription = textViewNewsDetailedDescription
        val textViewNewsDetailedTitle = textViewNewsDetailedTitle
        val textViewNewsDetailedPublishedAt = textViewNewsDetailedPublishedAt
        val imageNewsDetailed = imageNewsDetailed
        val bundle = this.arguments
        if (bundle != null) {
            textViewNewsDetailedTitle.text = bundle.getString("title")
            textViewNewsDetailedDescription.text = bundle.getString("description")
            textViewNewsDetailedAuthor.text = bundle.getString("author")
            textViewNewsDetailedPublishedAt.text = bundle.getString("publishedAt")
            val IMAGE_BASE = bundle.getString("image")
            Glide.with(imageNewsDetailed).load(IMAGE_BASE).into(imageNewsDetailed)
        }
    }
}
