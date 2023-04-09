package com.example.gameword.activities.ui.stats

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.gameword.R
import com.example.gameword.base.BaseFragment
import com.example.gameword.databinding.FragmentStatsBinding

class StatsFragment : BaseFragment() {
    var binding: FragmentStatsBinding ?=null
    private lateinit var viewModel: StatsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentStatsBinding.inflate(inflater, container, false)
        return binding!!.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(StatsViewModel::class.java)
        // TODO: Use the ViewModel
    }

}