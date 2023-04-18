package com.example.gameword.activities

import android.content.Intent
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.gameword.R
import com.example.gameword.base.BaseActivity
import com.example.gameword.databinding.ActivityHomeBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.yarolegovich.slidingrootnav.SlidingRootNav
import com.yarolegovich.slidingrootnav.SlidingRootNavBuilder

class ActivityHome : BaseActivity() {

    private lateinit var binding: ActivityHomeBinding
    private var slidingRootNav: SlidingRootNav? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.bottomNavigationView

        val navController = findNavController(R.id.nav_host_fragment_activity_home)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        navView.setupWithNavController(navController)

        setListeners(savedInstanceState = savedInstanceState)
    }

    private fun setListeners(savedInstanceState:Bundle?) {
        binding.ivSlidingRootNav.setOnClickListener {
            if(slidingRootNav == null) {
                slidingRootNav = SlidingRootNavBuilder(this).withMenuOpened(false)
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
            startActivity(Intent(this, ActivityNotifications::class.java))
        }

    }
}