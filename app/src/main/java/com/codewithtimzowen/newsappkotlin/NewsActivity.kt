package com.codewithtimzowen.newsappkotlin

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.codewithtimzowen.newsappkotlin.databinding.ActivityNewsBinding

class NewsActivity : AppCompatActivity() {

    private lateinit var binding : ActivityNewsBinding
    private var mp : MediaPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bundle : Bundle? = intent.extras

        val heading = bundle!!.getString("heading")
        val imageID = bundle.getInt("imageid")
        val news = bundle.getString("news")
        val sounds = bundle.getInt("sound")

        binding.heading.text = heading
        binding.moreNews.text = news
        binding.imageMoreNew.setImageResource(imageID)

        binding.btnPlaySong.setOnClickListener {

             mp = MediaPlayer.create(this,sounds)
             mp?.start()
        }

    }
}