package com.example.newsapplication.activities

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.VolleyError
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.newsapplication.R
import com.example.newsapplication.data.NewsListAdapter
import com.example.newsapplication.model.News
import org.json.JSONException
import org.json.JSONObject

class SportsNews() : AppCompatActivity() {

    var volleyRequest: RequestQueue? = null
    var newsList: ArrayList<News>? = null
    var newsAdapter: NewsListAdapter? = null
    var layoutManager: RecyclerView.LayoutManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.news_activity)

        // Sports url
        var urlString = "http://api.datanews.io/v1/news?topic=sports&q=sports&language=en&sortBy=date&apiKey=06qmzxf874s9m7dmuiajxv40e"

        //set the title for the activity
        val text = findViewById<View>(R.id.categories_title) as TextView
        text.setText(R.string.sports)


        //instantiate the news
        newsList = ArrayList<News>()

        // instantiate the volley Request
        volleyRequest = Volley.newRequestQueue(this)

        getNews(urlString)
    }

    fun getNews(url: String) {
        val newsRequest = JsonObjectRequest(Request.Method.GET, url,
                { response: JSONObject ->
                    try {
                        val resultArray = response.getJSONArray("hits")
                        for (i in 0 until resultArray.length()){

                            var newsObj = resultArray.getJSONObject(i)

                            var title = newsObj.getString("title")
                            var source = newsObj.getString("source") // change name to source
                            var date = newsObj.getString("pubDate")
                            var image = newsObj.getString("imageUrl")
                            var sendButton = newsObj.getString("url")
                            var articleButton = newsObj.getString("url")

                            Log.d("Result===============> ", title)

                            var news = News()
                            news.title = title
                            news.source = source
                            news.date = date
                            news.image = image
                            news.sendURL = sendButton
                            news.article = articleButton
                            newsList!!.add(news)

                            //instantiate the adapter
                            newsAdapter = NewsListAdapter(newsList!!, this)
                            layoutManager = LinearLayoutManager(this)

                            // set up the RecyclerView
                            val recyclerView = findViewById<View>(R.id.recycler_view) as RecyclerView
                            recyclerView.layoutManager = layoutManager
                            recyclerView.adapter = newsAdapter


                        }
                        newsAdapter!!.notifyDataSetChanged()

                    }catch (e: JSONException) {
                        e.printStackTrace()
                    }

                },
                {
                    error: VolleyError? ->
                    try {
                        Log.d("Error: ", error.toString())

                    }catch (e: JSONException){
                        e.printStackTrace()
                    }
                }
        )

        volleyRequest!!.add(newsRequest)

    }

    fun buttonClick(view: View){
        val intent = Intent(this, MainActivity::class.java )
        startActivity(intent)
    }

}