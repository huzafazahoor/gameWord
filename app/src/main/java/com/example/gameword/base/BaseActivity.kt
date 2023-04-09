package com.example.gameword.base

import android.app.Activity
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.gameword.R
import com.example.gameword.utils.Email
import com.example.gameword.utils.Password
import com.tapadoo.alerter.Alerter
import java.util.regex.Pattern

abstract class BaseActivity:AppCompatActivity() {
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


    protected open fun isPasswordAndConfirmPasswordMatchedAndValidAndNonEmpty(
        password: String,
        confirmPassword: String
    ): Password? {
        return if (!password.isEmpty() && !confirmPassword.isEmpty()) {
            if (password.length < 8 && confirmPassword.length < 8) {
                Password.BOTH_LESS_THAN_8_CHARACTERS
            } else if (password.length < 8) {
                Password.PASSWORD_LESS_THAN_EIGHT_CHARACTERS
            } else if (confirmPassword.length < 8) {
                Password.CONFIRM_PASSWORD_LESS_THAN_EIGHT_CHARACTERS
            } else {
                if (password == confirmPassword) {
                    Password.PASSWORD_MATCHED
                } else {
                    Password.PASSWORD_NOT_MATCHED
                }
            }
        } else {
            Password.PASSWORDS_FIELDS_EMPTY
        }
    }

    protected open fun isEmailValidAndNonEmpty(email: String): Email? {
        return if (email.isEmpty()) {
            Email.EMAIL_FIELD_EMPTY
        } else {
            if (Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9+_.-]+$").matcher(email).matches()) {
                Email.EMAIL_VALID
            } else {
                Email.EMAIL_NOT_VALID
            }
        }
    }
}