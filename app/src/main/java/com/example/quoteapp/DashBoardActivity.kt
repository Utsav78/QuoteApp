package com.example.quoteapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class DashBoardActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dash_board)
    }

    fun onShuffle(view: View) {

        Intent(this,ListActivity::class.java).apply {
            putExtra("name","quotes.json")
            startActivity(this)
        }

    }

    fun onHope(view: View) {

        Intent(this,ListActivity::class.java).apply {
            putExtra("name","hope.json")
            startActivity(this)
        }

    }
}