package com.codewithtimzowen.newsappkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.codewithtimzowen.newsappkotlin.databinding.ActivityNewsBinding

class NewsActivity : AppCompatActivity() {

//    private lateinit var headingNews : TextView
//    private lateinit var mainNews : TextView
//    private lateinit var imageNews : ImageView
    private lateinit var binding : ActivityNewsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewsBinding.inflate(layoutInflater)
        setContentView(binding.root)

//         var headingNews  : TextView = findViewById(R.id.heading)
//         var mainNews : TextView  = findViewById(R.id.more_news)
//        var imageNews : ImageView  = findViewById(R.id.title_image)

        val bundle : Bundle? = intent.extras

        val heading = bundle!!.getString("heading")
        val imageID = bundle.getInt("imageId")
        val news = bundle.getString("news")

        binding.heading.text = heading
        binding.moreNews.text = news
        binding.imageMoreNew.setImageResource(imageID)

    }
}