package com.example.newsapplication.activities

import android.os.Bundle
import android.webkit.WebView
import androidx.appcompat.app.AppCompatActivity
import com.example.newsapplication.R

class Article : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.article_layout)
        var webView = findViewById<WebView>(R.id.webView)
        var extraIntent = intent.extras

        if(extraIntent != null) {
            var link = extraIntent.get("article")
            webView.loadUrl(link.toString())
        }

    }

}