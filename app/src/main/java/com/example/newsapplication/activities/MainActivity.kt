package com.example.newsapplication.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.ImageButton
import com.example.newsapplication.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var searchButton = findViewById<ImageButton>(R.id.search_button)
        var searchInput = findViewById<EditText>(R.id.searchInput)

        searchButton.setOnClickListener {
            var intent = Intent(this, TopNews::class.java)

            var input = searchInput.text.toString().trim()
            intent.putExtra("Search News", input)
            startActivity(intent)
        }

    }

    fun buttonClick(view: View){
        val intent = Intent(this, TopNews::class.java)
        startActivity(intent)
    }

    fun topNewsButton(view: View){
        val intent = Intent(this, TopNews::class.java)
        startActivity(intent)
    }

    fun politicsButton(view: View){
        val intent = Intent(this, PoliticsNews::class.java)
        startActivity(intent)
    }

    fun sportsButton(view: View){
        val intent = Intent(this, SportsNews::class.java)
        startActivity(intent)
    }

    fun financeButton(view: View){
        val intent = Intent(this, FinanceNews::class.java)
        startActivity(intent)
    }

    fun celebButton(view: View){
        val intent = Intent(this, CelebrityNews::class.java)
        startActivity(intent)
    }

    fun TvButton(view: View){
        val intent = Intent(this, EntertainmentNews::class.java)
        startActivity(intent)
    }

    fun techButton(view: View){
        val intent = Intent(this, TechNews::class.java)
        startActivity(intent)
    }

    fun ukButton(view: View){
        val intent = Intent(this, UkNews::class.java)
        startActivity(intent)
    }

    fun usButton(view: View){
        val intent = Intent(this, UsNews::class.java)
        startActivity(intent)
    }

    fun worldButton(view: View){
        val intent = Intent(this, WorldNews::class.java)
        startActivity(intent)
    }

}