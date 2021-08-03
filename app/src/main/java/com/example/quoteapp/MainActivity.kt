package com.example.quoteapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {
    private  val TAG = "MainActivity"
    lateinit var mainViewModel: MainViewModel

    private val quoteText: TextView
        get() = findViewById(R.id.quoteText)

    private val quoteAuthor: TextView
        get() = findViewById(R.id.quoteAuthor)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainViewModel = ViewModelProvider(this, MainViewModelFactory(application))
                        .get(MainViewModel::class.java)
        setQuote(mainViewModel.getQuote())

        if (intent != null) {
            val position = intent.getIntExtra("position",0)
            Log.d(TAG, "onCreate: $position")
            val quote: Quote = mainViewModel.quoteList[position]
            setQuote(quote)
        }




    }

    private fun setQuote(quote:Quote){
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
        intent.putExtra(Intent.EXTRA_TEXT, mainViewModel.getQuote().text)
        startActivity(intent)
    }

    fun onRandom(view: View) {
        setQuote(mainViewModel.randomQuote())
    }

    fun showInRecyclerView(view: View) {
        val intent = Intent(this,ListActivity::class.java)
        startActivity(intent)
    }

}
