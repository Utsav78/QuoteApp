package com.example.quoteapp

import android.content.Context
import android.util.Log
import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import java.nio.channels.AsynchronousFileChannel.open

class MainViewModel(val context: Context) : ViewModel() {
    private val TAG = "MainViewModel"

    var quoteList: Array<Quote> = emptyArray()
    private var quoteSize : Int =0
    private var index = 0

    init {
        quoteList = loadQuoteFromAssets()
        quoteSize = quoteList.size
        Log.d(TAG, "size of array : $quoteSize ")

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

    fun nextQuote() : Quote {
        ++index
       if (index == quoteSize) {
           index = 0
       }

        return quoteList[index]

    }

    fun previousQuote(): Quote {
        --index
        if (index == -1) {
            index = quoteSize - 1
        }

        return quoteList[index]
    }

    fun randomQuote():Quote {
        return quoteList[(0 until quoteSize).random()]
    }


}