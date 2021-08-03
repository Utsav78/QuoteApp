package com.example.quoteapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView

class TestActivity : AppCompatActivity() {

    companion object{
        private const val TAG = "TestActivity"

    }


    private val textView: TextView
        get() = findViewById(R.id.textView2)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)


        val position = intent.getIntExtra("position",10)

        textView.text = position.toString()

    }

}