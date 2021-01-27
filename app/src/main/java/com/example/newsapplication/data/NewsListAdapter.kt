package com.example.newsapplication.data

import android.content.Context
import android.content.Intent
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapplication.R
import com.example.newsapplication.activities.Article
import com.example.newsapplication.model.News
import com.squareup.picasso.Picasso

class NewsListAdapter(private val list: ArrayList<News>,
                        private val context: Context): RecyclerView.Adapter<NewsListAdapter.ViewHolder>() {


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if (holder != null) {
            holder.bindView(list[position])
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context)
                .inflate(R.layout.news_list_row, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var title = itemView.findViewById<TextView>(R.id.articleTitle)
        var source = itemView.findViewById<TextView>(R.id.articleSource)
        var date = itemView.findViewById<TextView>(R.id.articleDate)
        var image = itemView.findViewById<ImageView>(R.id.image_card_view)
        var sendButton =  itemView.findViewById<ImageButton>(R.id.send_article)
        var articleButton = itemView.findViewById<ImageButton>(R.id.view_article)

        fun bindView(news: News){
            title.text = news.title
            source.text = news.source
            date.text = news.date

            if (!TextUtils.isEmpty(news.image)) {
                Picasso.with(context).load(news.image)
                        .placeholder(R.drawable.ic_baseline_image_24)
                        .error(R.drawable.ic_baseline_image_24)
                        .fit()
                        .into(image)
            } else {
                Picasso.with(context).load(R.mipmap.ic_launcher).into(image)
            }

            sendButton.setOnClickListener {
                var shareIntent =  Intent(Intent.ACTION_SEND);
                shareIntent.putExtra(Intent.EXTRA_TEXT, "Check out this story:  " + news.sendURL.toString());
                shareIntent.type = "text/html";
                context.startActivity(Intent.createChooser(shareIntent, "Send via: "))
            }

            articleButton.setOnClickListener {
                var intent = Intent(context, Article::class.java)
                intent.putExtra("article", news.article.toString())
                context.startActivity(intent)
            }

        }

    }

}