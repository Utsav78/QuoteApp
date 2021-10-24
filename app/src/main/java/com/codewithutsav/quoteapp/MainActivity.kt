package com.codewithutsav.quoteapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.example.quoteapp.R
import kotlin.text.Typography.quote

class MainActivity : AppCompatActivity() {
    private lateinit var mainViewModel: MainViewModel

    private val quoteText: TextView
        get() = findViewById(R.id.quoteText)

    private val quoteAuthor: TextView
        get() = findViewById(R.id.quoteAuthor)

    private lateinit var name : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val position = intent.getIntExtra("position",0)
        name = intent.getStringExtra("name").toString()

        mainViewModel = ViewModelProvider(this, MainViewModelFactory(application,name))
                        .get(MainViewModel::class.java)
        var quote : Quote = mainViewModel.quoteList[position]
        setQuote(quote)

    }

    private fun setQuote(quote: Quote){
        quoteText.text = quote.text
        quoteAuthor.text = quote.author
    }

    fun onPrevious(view: View) {
        setQuote(mainViewModel.previousQuote())
    }

    fun onNext(view: View) {
        setQuote(mainViewModel.nextQuote())
    }

    

    fun onShare(view: View) {
        val intent = Intent(Intent.ACTION_SEND)
        intent.type = "text/plain"
        intent.putExtra(Intent.EXTRA_TEXT, quoteText.text)
        startActivity(intent)
    }

    fun onRandom(view: View) {
        setQuote(mainViewModel.randomQuote())
    }

}
