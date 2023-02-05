package com.example.myapplication_task.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication_task.R
import com.example.myapplication_task.model.ListModel


class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
class ListItemAdapter(val subsections : ArrayList<ListModel>) : RecyclerView.Adapter<ListViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        return ListViewHolder(LayoutInflater
            .from(parent.context)
            .inflate(R.layout.adapter_list_item,parent,false))
    }
    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.itemView.findViewById<ImageView>(R.id.imageView)
            .setImageResource(subsections.get(position).image)
        holder.itemView.findViewById<TextView>(R.id.textView).text = subsections.get(position).title
    }
    override fun getItemCount(): Int {
        return subsections.size
    }
    fun notifyDataSetChanged(list : ArrayList<ListModel>) {
        subsections.clear()
        subsections.addAll(list)
        notifyDataSetChanged()
    }


}