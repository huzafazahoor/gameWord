package com.example.gameword.base

import android.R
import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import com.tapadoo.alerter.Alerter

open class BaseActivity:AppCompatActivity() {
    fun showErrorDialog(activity: Activity, message: String) {
        Alerter.create(activity = activity)
            .showIcon(false)
            .setDuration(1200)
            .setBackgroundColorRes(R.color.holo_red_dark)
            .setText(message)
            .show()
    }

    fun showDialog(activity: Activity, showIcon: Boolean, backgroundColorRes: Int, message: String, iconRes: Int, duration:Long) {
        Alerter.create(activity = activity)
            .showIcon(showIcon)
            .setBackgroundColorRes(backgroundColorRes)
            .setText(message)
            .setIcon(iconRes)
            .setDuration(duration)
            .show();
    }
}