package com.example.quoteapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class QuotesAdapter(private val quoteList: Array<Quote>) :
    RecyclerView.Adapter<QuotesAdapter.ViewHolder>() {


     inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
         private val view = itemView
         val textView : TextView = view.findViewById(R.id.quote_text)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.quote_list,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textView.text = quoteList[position].text
    }

    override fun getItemCount(): Int {
        return quoteList.size
    }
}