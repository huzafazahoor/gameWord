package com.example.gameword.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.gameword.databinding.ListItemSliderTournamentBinding
import com.example.gameword.modals.FeaturedTournament

class FeaturedTournamentsImageSliderAdapter(var context: Context) :
    RecyclerView.Adapter<FeaturedTournamentsImageSliderAdapter.ViewHolder>() {
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

    override fun getItemCount(): Int {
        return 10
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.mtvName.text = position.toString()
    }


    class ViewHolder(binding: ListItemSliderTournamentBinding) : RecyclerView.ViewHolder(binding.root) {
        var binding = binding
    }
}