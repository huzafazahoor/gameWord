package com.example.gameword.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.gameword.activities.ActivityGameDetails
import com.example.gameword.activities.ActivityGamesDetails
import com.example.gameword.databinding.ListItemFeaturedGameBinding
import com.example.gameword.modals.FeaturedGame

class FeaturedGamesAdapter(var context: Context) : RecyclerView.Adapter<FeaturedGamesAdapter.ViewHolder>() {
    var featuredGamesList: ArrayList<FeaturedGame> ?= null
        set(value) {
            field = value
        }
        get() {
            return featuredGamesList
        }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ListItemFeaturedGameBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    /**
     * SET DATA ACCORDING TO YOUR NEEDS AND CONTROLLING
     * PASS DATA THROUGH INTENT USING PUT EXTRA AND YOU'LL BE ABLE TO PASS WHOLE OBJECT AS
     * SERIALIZABLE BY IMPLEMENTING IT
     * Example: intent.putExtra(<KEY>, <SERIALIZABLE OBJECT>)
     */
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.root.setOnClickListener {
            var intent = Intent(context, ActivityGameDetails::class.java)
            context.startActivity(intent)
        }
    }

    /**
     * RETURN featuredGamesList.size IF THE VIEW ALL PAGE IS OPENED FOR FRAGMENT HOME RETURN THE
     * SPECIFIC SIZE ACCORDING TO THE LIST
     *
     * TO DO THIS YOU CAN PASS A SPECIFIC KEY IN CONSTRUCTOR AND ADD IF CONDITION OR SET THE ARRAY
     * LIST ACCORDING TO THIS SPECIFIC SIZE
     */
    override fun getItemCount(): Int {
        return 10
    }

    class ViewHolder(var binding: ListItemFeaturedGameBinding) : RecyclerView.ViewHolder(binding.root) {

    }
}