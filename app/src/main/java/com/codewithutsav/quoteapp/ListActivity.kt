package com.codewithutsav.quoteapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.quoteapp.R

class ListActivity : AppCompatActivity() , QuotesAdapter.OnItemClickListener {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: QuotesAdapter
    private lateinit var viewModel: MainViewModel
    private lateinit var name : String

    companion object {
        private const val TAG = "ListActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        val toolbar : Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        name  = intent.getStringExtra("name").toString()
        title = name.uppercase().replaceAfterLast(".","")

        viewModel = ViewModelProvider(this, MainViewModelFactory(application,name))
                    .get(MainViewModel::class.java)
        adapter = QuotesAdapter(viewModel.quoteList, this)

        val layoutManager = LinearLayoutManager(this)
        recyclerView = findViewById(R.id.recycler_view)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = adapter

    }

    override fun onItemClick(position: Int) {
        Log.d(TAG, "onItemClick: $position ")
        Intent(this, MainActivity::class.java).apply {
            putExtra("position",position)
            putExtra("name",name)
            startActivity(this)
        }
    }

}