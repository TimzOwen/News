package com.codewithtimzowen.newsappkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.codewithtimzowen.newsappkotlin.adapter.NewsAdapter
import com.codewithtimzowen.newsappkotlin.data.News

class MainActivity : AppCompatActivity() {

    private lateinit var newsRecyclerView  :RecyclerView
    private lateinit var newsArrayList : ArrayList<News>
    lateinit var imageID : Array<Int>
    lateinit var heading : Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        imageID = arrayOf(
            R.drawable.new1,
            R.drawable.new2,
            R.drawable.new3,
            R.drawable.new4,
            R.drawable.new5,
            R.drawable.new6
        )

        heading = arrayOf(
            "Uhuru Kenya to end Curview hours ",
            "Kabarak University graduatoion on september",
            "Kenya 7s wins tge world cup final champions",
            "Timz Owen to be elected the CS for ICT Kenya",
            "From university to building multibillion school for educaiton ",
            "Get all the breaking news by downloading this app "
        )

        newsRecyclerView = findViewById(R.id.recycler_view)
        newsRecyclerView.layoutManager = LinearLayoutManager(this)
        newsRecyclerView.hasFixedSize()

        newsArrayList = arrayListOf<News>()

        getData()

    }

    private fun getData() {

        for (i in imageID.indices){
            val news = News(imageID[i],heading[i])
            newsArrayList.add(news)
        }
        newsRecyclerView.adapter = NewsAdapter(newsArrayList)
    }
}