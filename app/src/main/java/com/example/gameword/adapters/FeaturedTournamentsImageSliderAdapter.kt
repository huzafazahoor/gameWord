package com.example.gameword.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.gameword.databinding.ListItemSliderTournamentBinding
import com.example.gameword.modals.FeaturedTournament

class FeaturedTournamentsImageSliderAdapter(var context: Context) : RecyclerView.Adapter<FeaturedTournamentsImageSliderAdapter.ViewHolder>() {
    private var tournamentSliderList: ArrayList<FeaturedTournament> ?= null
        get() {
            return tournamentSliderList
        }
        set(value) {
            field = value
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ListItemSliderTournamentBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    /**
     * RETURN featuredGamesList.size IF THE VIEW ALL PAGE IS OPENED OTHERWISE RETURN THE SPECIFIC SIZE ACCORDING TO THE LIST
     */
    override fun getItemCount(): Int {

        return 10
    }

    /**
     * SET DATA ACCORDING TO YOUR NEEDS AND CONTROLLING
     * PASS DATA THROUGH INTENT USING PUT EXTRA AND YOU'LL BE ABLE TO PASS WHOLE OBJECT AS SERIALIZABLE BY IMPLEMENTING IT
     * Example: intent.putExtra(<KEY>, <SERIALIZABLE OBJECT>)
     */
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.mtvName.text = position.toString()
        holder.binding.root.setOnClickListener {

        }
    }


    class ViewHolder(var binding: ListItemSliderTournamentBinding) : RecyclerView.ViewHolder(binding.root) {

    }
}