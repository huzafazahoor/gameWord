package com.example.gameword.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.gameword.R

class RecyclerViewAdapter : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> () {

    public var name = arrayOf("Knife hit", "Subway surfer")
    public var number = arrayOf("Easy", "Hard")

        get() = field
        set(value){
            field = value
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.list_item_featured_game, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: RecyclerViewAdapter.ViewHolder, position: Int) {
//        holder.ContactName.text = name[position]
//        holder.ContactNumber.text = number[position]
    }

    override fun getItemCount(): Int {
        return name.size
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
//        var ContactName : TextView
//        var ContactNumber : TextView

//        init {
//            ContactName = itemView.findViewById(R.id.textView)
//            ContactNumber = itemView.findViewById(R.id.textView2)
//        }
    }


}