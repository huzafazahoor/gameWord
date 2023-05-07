package com.example.gameword.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.gameword.R
import com.example.gameword.databinding.ListItemPlayerStatsBinding

class AdapterPlayerStats(var context: Context): RecyclerView.Adapter<AdapterPlayerStats.ViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): ViewHolder {
        return ViewHolder(ListItemPlayerStatsBinding.inflate(LayoutInflater.from(parent.context),parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.apply {
            when (position) {
                0 -> {
                    llCard.setBackgroundResource(R.drawable.bg_drawable_golden)
                }
                1 -> {
                    llCard.setBackgroundResource(R.drawable.bg_drawable_silver)

                }
                2 -> {
                    llCard.setBackgroundResource(R.drawable.bg_drawable_bronze)
                }
                else -> {
                    llCard.setBackgroundResource(R.drawable.bg_gradient_btn)
                }
            }

        }
    }

    override fun getItemCount(): Int {
        return 10
    }

    class ViewHolder(var binding: ListItemPlayerStatsBinding) : RecyclerView.ViewHolder(binding.root) {
    }
}