package com.example.gameword.activities.ui.stats

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gameword.R
import com.example.gameword.adapters.AdapterPlayerStats
import com.example.gameword.base.BaseFragment
import com.example.gameword.databinding.FragmentStatsBinding

class StatsFragment : BaseFragment() {
    var binding: FragmentStatsBinding ?=null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentStatsBinding.inflate(inflater, container, false)
        return binding!!.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setListeners()
        setAdapter()
    }


    private fun setListeners() {

    }

    private fun setAdapter() {
        val adapter = context?.let { AdapterPlayerStats(it) }
        binding?.apply {
            rvStats.layoutManager = LinearLayoutManager(context)
            rvStats.adapter = adapter
        }
    }
}