package com.example.odev_4.services

import android.util.Log
import com.example.odev_4.models.News
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.select.Elements

class NewsService {

    fun news() : List<News>{
        val arr = mutableListOf<News>()
        val url = "https://www.gazetevatan.com/"
        val doc : Document = Jsoup.connect(url).timeout(15000).get()
        val elements : Elements = doc.getElementsByClass("swiper-slide__link")
        for (element in elements){
            val img = element.getElementsByTag("img")
            val href = element.attr("abs:href")
            val src = img.attr("data-src")
            val title = img.attr("alt")
            if(title.isNotEmpty() && src.isNotEmpty() && href.isNotEmpty()){
                val news = News(title,src,href)
                arr.add(news)
            }
        }
        return arr
    }
}