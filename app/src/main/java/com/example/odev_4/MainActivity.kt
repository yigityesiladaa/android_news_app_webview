package com.example.odev_4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.odev_4.adapters.CustomNewsAdapter
import com.example.odev_4.databinding.ActivityMainBinding
import com.example.odev_4.models.News
import com.example.odev_4.services.NewsService

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private var news = listOf<News>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var result = NewsService()
        val run = Runnable {
            news = result.news()
            updateUI()
        }
        Thread(run).start()
    }

    private fun updateUI(){
        runOnUiThread {
            if (news.isNotEmpty()) {
                binding.progressBar.visibility = View.GONE
                val customNewsAdapter = CustomNewsAdapter(this, news)
                binding.newsListView.adapter = customNewsAdapter
            }
        }
    }
}