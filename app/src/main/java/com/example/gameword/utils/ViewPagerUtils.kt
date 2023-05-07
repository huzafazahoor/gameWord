package com.example.gameword.utils

import android.os.Handler
import android.os.Looper
import androidx.viewpager2.widget.ViewPager2

class ViewPagerUtils {
    companion object {
        fun setScrollOnFeaturedTournaments(viewPager2: ViewPager2) {
            val scrollHandler = Handler(Looper.getMainLooper())
            val scrollRunnable = object : Runnable {
                override fun run() {
                    val currentPosition = viewPager2.currentItem
                    val nextPosition =
                        (currentPosition + 1) % viewPager2.adapter!!.itemCount
                    viewPager2.setCurrentItem(nextPosition, true)
                    scrollHandler.postDelayed(this, 2000)
                }
            }
            viewPager2.registerOnPageChangeCallback(object :
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

            viewPager2.postDelayed(scrollRunnable, 2000)
        }
    }
}