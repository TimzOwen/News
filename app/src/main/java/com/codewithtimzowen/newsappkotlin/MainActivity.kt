package com.codewithtimzowen.newsappkotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.codewithtimzowen.newsappkotlin.adapter.NewsAdapter
import com.codewithtimzowen.newsappkotlin.data.News

class MainActivity : AppCompatActivity() {

    private lateinit var newsRecyclerView  :RecyclerView
    private lateinit var newsArrayList : ArrayList<News>
    lateinit var imageID : Array<Int>
    lateinit var heading : Array<String>
    lateinit var news : Array<String>
    lateinit var soundNews : Array<Int>

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

        soundNews = arrayOf(
            R.raw.podcast2,
            R.raw.podcast3,
            R.raw.podcast4,
            R.raw.podcast5,
            R.raw.podcast7,
            R.raw.podcast8
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

        news = arrayOf(
            getString(R.string.news11),
            getString(R.string.news12),
            getString(R.string.news13),
            getString(R.string.news14),
            getString(R.string.news15),
            getString(R.string.news16),
            getString(R.string.news17),
        )
    }
    private fun getData() {

        for (i in imageID.indices){
            val news = News(imageID[i],heading[i])
            newsArrayList.add(news)
        }

        val adapter =  NewsAdapter(newsArrayList)
        newsRecyclerView.adapter =adapter
        adapter.setOnClickListener(object : NewsAdapter.OnItemClickListener{
            override fun onClick(position: Int) {

                // attach data to be sent to the next activity

                val intent = Intent(this@MainActivity, NewsActivity::class.java)
                intent.putExtra("heading",newsArrayList[position].heading)
                intent.putExtra("imageid",newsArrayList[position].titleImage)
                intent.putExtra("news",news[position])
                intent.putExtra("sound",soundNews[position])
                startActivity(intent)

            }
        })
    }
}