package com.example.gameword.activities.ui.home


import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.example.gameword.R
import com.example.gameword.activities.ActivityAllFeaturedGames
import com.example.gameword.activities.ActivityNotifications
import com.example.gameword.adapters.FeaturedGamesAdapter
import com.example.gameword.adapters.FeaturedTournamentsImageSliderAdapter
import com.example.gameword.base.BaseFragment
import com.example.gameword.databinding.FragmentHomeBinding
import com.yarolegovich.slidingrootnav.SlidingRootNav
import com.yarolegovich.slidingrootnav.SlidingRootNavBuilder


class HomeFragment : BaseFragment() {

    private lateinit var binding: FragmentHomeBinding
    private var handler: Handler? = null
    private val scrollHandler = Handler(Looper.getMainLooper())
    private var slidingRootNav: SlidingRootNav? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        handler = Handler(Looper.getMainLooper())
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setListeners(savedInstanceState)
        setAdapters()
        setScrollOnFeaturedTournaments()

    }

    private fun setListeners(savedInstanceState: Bundle?) {
        binding.mtvViewAll.setOnClickListener {
            startActivity(Intent(context, ActivityAllFeaturedGames::class.java))
        }

        binding.ivSlidingRootNav.setOnClickListener {
            if(slidingRootNav == null) {
                slidingRootNav = SlidingRootNavBuilder(activity).withMenuOpened(false)
                    .withContentClickableWhenMenuOpened(false)
                    .withSavedState(savedInstanceState)
                    .withMenuLayout(R.layout.menu_left_drawer)
                    .withContentClickableWhenMenuOpened(false)
                    .withRootViewElevation(10)
                    .withRootViewScale(0.5.toFloat())
                    .inject()
            }
            slidingRootNav?.openMenu()
        }

        binding.ivNotifications.setOnClickListener {
            startActivity(Intent(activity, ActivityNotifications::class.java))
        }
    }

    private fun setAdapters() {
        binding.vpSliderFeaturedTournaments.adapter = context?.let { FeaturedTournamentsImageSliderAdapter(it)}
        binding.rvFeaturedGames.adapter = context?.let { FeaturedGamesAdapter(context = it) }
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