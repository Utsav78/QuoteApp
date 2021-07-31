package com.example.quoteapp

import android.content.Context
import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import java.nio.channels.AsynchronousFileChannel.open

class MainViewModel(val context: Context) : ViewModel() {
    private var quoteList: Array<Quote> = emptyArray()
    private var quoteSize : Int =0
    private var index = 0

    init {
        quoteList = loadQuoteFromAssets()
        quoteSize = quoteList.size

    }

    private fun loadQuoteFromAssets(): Array<Quote> {
        val inputStream = context.assets.open("quotes.json")
        val size : Int = inputStream.available()
        val buffer = ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()
        val json = String(buffer, Charsets.UTF_8)
        val gson = Gson()
        return gson.fromJson(json, Array<Quote>::class.java)
    }

    fun getQuote() = quoteList[index]

    fun nextQuote() = quoteList[++index ]

    fun previousQuote() = quoteList[--index]

    fun randomQuote():Quote {
        return quoteList[(0..quoteList.size).random()]
    }


}