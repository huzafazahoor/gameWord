package com.example.gameword.activities

import android.content.Intent
import android.os.Bundle
import com.example.gameword.base.BaseActivity
import com.example.gameword.databinding.ActivityLoginBinding
import com.example.gameword.utils.Email
import com.example.gameword.utils.Password

class ActivityLogin : BaseActivity() {
    private var binding: ActivityLoginBinding ?= null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding!!.root)
        setListeners()
    }

    private fun setListeners() {
        binding!!.tvLogin.setOnClickListener {
            val password: String = binding!!.tiePassword.text.toString()
            val email: String = binding!!.tieEmail.text.toString()
            val confirmPassword: String = password
            val passwordValidationResult: Password? = isPasswordAndConfirmPasswordMatchedAndValidAndNonEmpty(password, confirmPassword)
            val emailValidationResult: Email? = isEmailValidAndNonEmpty(email)
            if(emailValidationResult == Email.EMAIL_VALID && passwordValidationResult == Password.PASSWORD_MATCHED) {
                //TODO - PERFORM LOGIN
                startActivity(Intent(this@ActivityLogin, ActivityHome::class.java).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK))
            } else if (emailValidationResult == Email.EMAIL_NOT_VALID) {
                showErrorDialog(this@ActivityLogin, "Please enter valid email address.")
            } else if (passwordValidationResult == Password.BOTH_LESS_THAN_8_CHARACTERS) {
                showErrorDialog(this@ActivityLogin, "Password must be at least 8 characters long.")
            }
            else {
                showErrorDialog(this@ActivityLogin, "Please fill all required fields.")
            }
        }

        binding!!.tvNewMember.setOnClickListener {
            startActivity(Intent(this@ActivityLogin, ActivityRegistration::class.java))
        }
    }

}