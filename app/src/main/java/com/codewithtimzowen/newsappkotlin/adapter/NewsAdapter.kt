package com.codewithtimzowen.newsappkotlin.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.codewithtimzowen.newsappkotlin.R
import com.codewithtimzowen.newsappkotlin.data.News

class NewsAdapter(private val newArrayList : ArrayList<News>) : RecyclerView.Adapter<NewsAdapter.NewsViewHolder> (){



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_list,parent,false)
        return NewsViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val currentNewsItem = newArrayList[position]

        holder.titleImage.setImageResource(currentNewsItem.titleImage)
        holder.tvHeading.text = currentNewsItem.heading
    }

    override fun getItemCount(): Int {
        return newArrayList.size
    }


    class NewsViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {

        val titleImage : ImageView = itemView.findViewById(R.id.title_image)
        val tvHeading : TextView = itemView.findViewById(R.id.tv_heading)

    }


}