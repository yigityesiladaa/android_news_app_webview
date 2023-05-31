package com.example.odev_4.adapters

import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.odev_4.R
import com.example.odev_4.models.News
import com.example.odev_4.screens.NewsDetailActivity

class CustomNewsAdapter(private val context : Activity, private val list : List<News>)
    : ArrayAdapter<News>(context,R.layout.news_list_item) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val rootView = LayoutInflater.from(context).inflate(R.layout.news_list_item,null,true)

        val linearLayout = rootView.findViewById<LinearLayout>(R.id.linearLayout)
        val imgNewsImageView = rootView.findViewById<ImageView>(R.id.imgNewsImageView)
        val txtNewsTitle = rootView.findViewById<TextView>(R.id.txtNewsTitle)

        val news = list[position]
        Glide.with(rootView).load(news.src).into(imgNewsImageView)
        txtNewsTitle.text = news.title

        linearLayout.setOnClickListener{
            val intent = Intent(context,NewsDetailActivity::class.java)
            intent.putExtra("href",news.href)
            context.startActivity(intent)
        }
        return rootView
    }

    override fun getCount(): Int {
        return list.count()
    }
}