package com.codewithutsav.quoteapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.quoteapp.R

class QuotesAdapter(
    private val quoteList: Array<Quote>,
    private var listener: OnItemClickListener

) : RecyclerView.Adapter<QuotesAdapter.ViewHolder>() {


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


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) ,
    View.OnClickListener {

        val textView: TextView = itemView.findViewById(R.id.quote_text)

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            listener.onItemClick(adapterPosition)
        }
    }


    interface OnItemClickListener{
        fun onItemClick(position: Int)

    }
    /*fun setOnClick(listener: OnItemClickListener) {
        this.listener = listener

    }

     */
}