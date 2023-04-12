package com.example.gameword.adapters

import android.content.Context
import android.content.res.Resources
import android.util.TypedValue
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.view.setPadding
import androidx.viewpager.widget.PagerAdapter
import com.example.gameword.R
import kotlin.math.roundToInt

class FeaturedTournamentsImageSliderAdapter(var context:Context):PagerAdapter() {

    private val sliderImageIDs = arrayOf(R.drawable.shape_slider, R.drawable.shape_slider_2)
    override fun getCount(): Int {
        return sliderImageIDs.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == (`object` as ImageView)
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        var imageView = ImageView(context)
        imageView.scaleType = ImageView.ScaleType.FIT_CENTER
        var dip = 8f
        var r: Resources = context.resources
        var px = TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP,
            dip,
            r.displayMetrics
        )
        imageView.setPadding(px.roundToInt())
        imageView.setImageResource(sliderImageIDs[position])
        container.addView(imageView,0)
        return imageView
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as ImageView)
    }
}