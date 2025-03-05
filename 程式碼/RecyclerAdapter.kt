package com.example.book

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapter(private var booklist:ArrayList<book>):RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerAdapter.ViewHolder{
        val v = LayoutInflater.from(parent.context).inflate(R.layout.card_layout,parent,false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return booklist.size
    }

    override fun onBindViewHolder(holder:RecyclerAdapter.ViewHolder,position: Int) {
        val currentItem = booklist[position]
        holder.itemTitle.text = currentItem.title
        holder.itemDetail.text = currentItem.detail
        holder.itemNumTitle.text = currentItem.numtitle
        holder.itemNumDetail.text = currentItem.numdetail
    }


    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var itemTitle: TextView
        var itemDetail: TextView
        var itemNumTitle: TextView
        var itemNumDetail: TextView
        init {
            itemTitle = itemView.findViewById(R.id.item_title)
            itemDetail = itemView.findViewById(R.id.item_detail)
            itemNumTitle = itemView.findViewById(R.id.item_num_title)
            itemNumDetail = itemView.findViewById(R.id.item_num_detail)
        }
    }
}