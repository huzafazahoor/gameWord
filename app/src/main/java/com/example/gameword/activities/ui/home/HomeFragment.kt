package com.example.gameword.activities.ui.home


import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.gameword.R
import com.example.gameword.activities.ActivityGamesDetails
import com.example.gameword.activities.ActivityNotifications
import com.example.gameword.adapters.FeaturedGamesAdapter
import com.example.gameword.adapters.FeaturedTournamentsImageSliderAdapter
import com.example.gameword.base.BaseFragment
import com.example.gameword.databinding.FragmentHomeBinding
import com.example.gameword.utils.ViewPagerUtils
import com.yarolegovich.slidingrootnav.SlidingRootNav
import com.yarolegovich.slidingrootnav.SlidingRootNavBuilder


class HomeFragment : BaseFragment() {

    private lateinit var binding: FragmentHomeBinding

    private var slidingRootNav: SlidingRootNav? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setListeners(savedInstanceState)
        setAdapters()
        ViewPagerUtils.setScrollOnFeaturedTournaments(binding.vpSliderFeaturedTournaments)

    }

    private fun setListeners(savedInstanceState: Bundle?) {
        binding.mtvViewAll.setOnClickListener {
            startActivity(Intent(context, ActivityGamesDetails::class.java))
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



    override fun onDestroyView() {
        super.onDestroyView()
    }
}