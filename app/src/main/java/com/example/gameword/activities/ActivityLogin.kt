package com.example.gameword.activities

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.TextPaint
import android.text.style.ClickableSpan
import android.text.style.StyleSpan
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.gameword.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class ActivityLogin : AppCompatActivity() {


    private lateinit var edtEmail: EditText
    private lateinit var edtPassword: EditText
    private lateinit var btnLogin: Button

    private lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        mAuth = Firebase.auth

//        edtEmail = findViewById(R.id.edt_email)
//        edtPassword = findViewById(R.id.edt_password)
//        btnLogin = findViewById(R.id.btnLogin)
        printSignUp()

        btnLogin.setOnClickListener{
            val email = edtEmail.text.toString().trim()
            val password = edtPassword.text.toString().trim()

            login(email,password)
        }


    }

    private fun login(email: String, password: String){


        mAuth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {

                    Toast.makeText(this@ActivityLogin, "goodJOB", Toast.LENGTH_SHORT).show()
                    val sharedPreference =  getSharedPreferences("User", Context.MODE_PRIVATE)
                    val editor = sharedPreference.edit()
                    val userid = Firebase.auth.currentUser?.uid
                    editor.putString("UserId",userid)
                    editor.apply()

                    val intent = Intent(this@ActivityLogin, HomePage::class.java)

                    /*intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or
                            Intent.FLAG_ACTIVITY_NEW_TASK)*/
                    finish()
                    startActivity(intent)
                } else {
                    Toast.makeText(this@ActivityLogin, "User does not exist", Toast.LENGTH_SHORT).show()
                }
            }
    }


    private fun printSignUp(){
        val ss = SpannableString("Don't have an account? Sign Up now.")
        val clickableSpan: ClickableSpan = object : ClickableSpan() {

            override fun onClick(textView: View) {
                startActivity(Intent(this@ActivityLogin, SignUp::class.java))
            }

            override fun updateDrawState(ds: TextPaint) {
                super.updateDrawState(ds)
                ds.color = Color.CYAN
            }
        }
        ss.setSpan(clickableSpan, 23, 30, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)

        val boldSpan = StyleSpan(Typeface.BOLD)
        ss.setSpan(boldSpan, 23, 30, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)


//        val textView = findViewById<TextView>(R.id.signUpText)
//        textView.text = ss
//
//        textView.movementMethod = LinkMovementMethod.getInstance()
//        textView.highlightColor = Color.TRANSPARENT
    }
}