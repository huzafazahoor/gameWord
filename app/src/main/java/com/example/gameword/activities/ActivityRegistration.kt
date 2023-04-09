package com.example.gameword.activities

import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.Window
import android.widget.Toast
import com.example.gameword.base.BaseActivity
import com.example.gameword.databinding.ActivityRegistrationBinding
import com.example.gameword.databinding.LayoutDialogOtpBinding
import `in`.aabhasjindal.otptextview.OTPListener


class ActivityRegistration : BaseActivity() {
    private var binding: ActivityRegistrationBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistrationBinding.inflate(layoutInflater)
        setContentView(binding!!.root)
        setListeners()
    }

    private fun setListeners() {
        binding!!.tvRegister.setOnClickListener {
            var layoutDialogOtpBinding: LayoutDialogOtpBinding = LayoutDialogOtpBinding.inflate(layoutInflater)
            layoutDialogOtpBinding.otpView.otpListener = object : OTPListener {
                override fun onInteractionListener() {
                    //TODO - fired when user types something in the Otpbox
                }

                override fun onOTPComplete(otp: String) {
                    //TODO - fired when user has entered the OTP fully.
                    startActivity(Intent(this@ActivityRegistration, ActivityHome::class.java).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK))

                }
            }
            layoutDialogOtpBinding.tvVerify.setOnClickListener {
                //TODO - IN CASE onOTPComplete Didn't worked
                startActivity(Intent(this@ActivityRegistration, ActivityHome::class.java).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK))
            }
            var dialog = Dialog(this@ActivityRegistration)
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
            dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            dialog.setCancelable(false)
            dialog.setContentView(layoutDialogOtpBinding.root)
            dialog.show()
        }
    }
}