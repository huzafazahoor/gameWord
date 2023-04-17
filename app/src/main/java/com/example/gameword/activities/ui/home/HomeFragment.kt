package com.example.gameword.activities.ui.home

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.example.gameword.adapters.FeaturedTournamentsImageSliderAdapter
import com.example.gameword.base.BaseFragment
import com.example.gameword.databinding.FragmentHomeBinding


class HomeFragment : BaseFragment() {

    private lateinit var binding: FragmentHomeBinding
    private var handler: Handler? = null
    private val scrollHandler = Handler(Looper.getMainLooper())

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        handler = Handler()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setListeners()
        setAdapters()
        setScrollOnFeaturedTournaments()

    }

    private fun setListeners() {

    }

    private fun setAdapters() {
        binding.vpSliderFeaturedTournaments.adapter = context?.let {
            FeaturedTournamentsImageSliderAdapter(
                it
            )
        }
    }

    private val scrollRunnable = object : Runnable {
        override fun run() {
            val currentPosition = binding.vpSliderFeaturedTournaments.currentItem
            val nextPosition =
                (currentPosition + 1) % binding.vpSliderFeaturedTournaments.adapter!!.itemCount
            binding.vpSliderFeaturedTournaments.setCurrentItem(nextPosition, true)
            scrollHandler.postDelayed(this, 2000)
        }
    }
    private fun setScrollOnFeaturedTournaments() {
        binding.vpSliderFeaturedTournaments.registerOnPageChangeCallback(object :
            ViewPager2.OnPageChangeCallback() {

            override fun onPageScrollStateChanged(state: Int) {
                super.onPageScrollStateChanged(state)
                when (state) {
                    ViewPager2.SCROLL_STATE_IDLE -> {
                        scrollHandler.postDelayed(scrollRunnable, 2000)
                    }

                    ViewPager2.SCROLL_STATE_DRAGGING -> {
                        scrollHandler.removeCallbacks(scrollRunnable)
                    }

                    ViewPager2.SCROLL_STATE_SETTLING -> {
                        scrollHandler.removeCallbacks(scrollRunnable)
                    }
                }
            }
        })

        binding.vpSliderFeaturedTournaments.postDelayed(scrollRunnable, 2000)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        scrollHandler.removeCallbacks(scrollRunnable)
    }
}