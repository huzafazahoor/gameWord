package com.example.gameword.base

import android.app.Activity
import android.util.Log
import androidx.fragment.app.Fragment
import com.example.gameword.R
import com.tapadoo.alerter.Alerter

abstract class BaseFragment : Fragment() {
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

    protected open fun logMessageInfo(message: String?) {
        Log.i("LOG-D", message!!)
    }

    protected open fun logMessageDebug(message: String?) {
        Log.d("LOG-D", message!!)
    }

    protected open fun showLogInfoWithTitle(title: String?, message: String?) {
        Log.i(title, message!!)
    }

    protected open fun showLogDebugWithTitle(title: String?, message: String?) {
        Log.i(title, message!!)
    }
}