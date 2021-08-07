package com.example.quoteapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider

class DashBoardActivity : AppCompatActivity() {
    private lateinit var mainViewModel: MainViewModel

    private val quoteText: TextView
        get() = findViewById(R.id.quoteText)

    private val quoteAuthor: TextView
        get() = findViewById(R.id.quoteAuthor)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dash_board)

        mainViewModel = ViewModelProvider(this, MainViewModelFactory(application,"quotes.json"))
            .get(MainViewModel::class.java)
        val quote = mainViewModel.randomQuote()
        setQuote(quote)




    }


    private fun setQuote(quote:Quote){
        quoteText.text = quote.text
        quoteAuthor.text = quote.author
    }

    fun onHope(view: View) {

        Intent(this,ListActivity::class.java).apply {
            putExtra("name","hopes.json")
            startActivity(this)
        }

    }

    fun onInspiration(view: View) {
        Intent(this,ListActivity::class.java).apply {
            putExtra("name","inspirational.json")
            startActivity(this)
        }

    }
    fun onTruth(view: View) {
        Intent(this,ListActivity::class.java).apply {
            putExtra("name","truth.json")
            startActivity(this)
        }

    }
    fun onPhilosophy(view: View) {
        Intent(this,ListActivity::class.java).apply {
            putExtra("name","philosophy.json")
            startActivity(this)
        }

    }
    fun onHappiness(view: View) {
        Intent(this,ListActivity::class.java).apply {
            putExtra("name","happiness.json")
            startActivity(this)
        }

    }
    fun onWisdom(view: View) {
        Intent(this,ListActivity::class.java).apply {
            putExtra("name","wisdom.json")
            startActivity(this)
        }

    }
    fun onGoals(view: View) {
        Intent(this,ListActivity::class.java).apply {
            putExtra("name","goals.json")
            startActivity(this)
        }

    }
    fun onRelationship(view: View) {
        Intent(this,ListActivity::class.java).apply {
            putExtra("name","relationship.json")
            startActivity(this)
        }

    }
    fun onLove(view: View) {
        Intent(this,ListActivity::class.java).apply {
            putExtra("name","love.json")
            startActivity(this)
        }

    }
}