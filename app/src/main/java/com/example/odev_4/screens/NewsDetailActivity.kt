package com.example.odev_4.screens

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.odev_4.databinding.ActivityNewsDetailBinding

class NewsDetailActivity : AppCompatActivity() {
    private lateinit var binding : ActivityNewsDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewsDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val href = intent.getStringExtra("href")

        if(href != null){
            binding.webview.settings.javaScriptEnabled = true
            binding.webview.loadUrl(href)
        }else{
            binding.webview.loadUrl("https://www.google.com/")
        }
    }
}