package com.example.gameword.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.gameword.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import java.util.regex.Pattern

class SignUp : AppCompatActivity() {


    private lateinit var edtName: EditText
    private lateinit var edtEmail: EditText
    private lateinit var edtPhoneNumber: EditText
    private lateinit var edtPassword: EditText
    private lateinit var btnSignUp: Button

    private lateinit var mAuth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {



        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        mAuth = Firebase.auth
        viewInitializations()

        btnSignUp.setOnClickListener{
            val name = edtName.text.toString().trim()
            val email = edtEmail.text.toString().trim()
            val phoneNum = edtPhoneNumber.text.toString().trim()
            val password = edtPassword.text.toString().trim()
            if(validateInput())
            {
                signUp(name,email, phoneNum,password)
            }
        }
    }

    private fun viewInitializations() {
//        edtName = findViewById(R.id.edt_name)
//        edtEmail = findViewById(R.id.edt_email)
//        edtPassword = findViewById(R.id.edt_password)
//        edtPhoneNumber = findViewById(R.id.edt_phoneNum)
//        btnSignUp = findViewById(R.id.btnSignUp)

    }

    private fun validateInput(): Boolean {
        if (edtName.text.toString() == "") {
            edtName.error = "Please Enter Last Name"
            return false
        }
        if (edtEmail.text.toString() == "") {
            edtEmail.error = "Please Enter Email"
            return false
        }
        // checking the proper email format
        if (!isEmailValid(edtEmail.text.toString())) {
            edtEmail.error = "Please Enter Valid Email"
            return false
        }
        if (edtPhoneNumber.text.toString() == "") {
            edtPhoneNumber.error = "Please Enter Phone Number"
            return false
        }
        if (!checkPhoneFormat(edtEmail.text.toString())) {
            edtPhoneNumber.error = "Please Enter Valid Phone Number"
            return false
        }
        if (edtPassword.text.toString() == "") {
            edtPassword.error = "Please Enter Password"
            return false
        }
        val MIN_PASSWORD_LENGTH = 6
        if (edtPassword.text.length < MIN_PASSWORD_LENGTH) {
            edtPassword.error = "Password Length must be more than " + MIN_PASSWORD_LENGTH + "characters"
            return false
        }
        return true
    }

    private fun isEmailValid(email: String): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    fun checkPhoneFormat(phone: String): Boolean {

        val REG = "^([0-9\\+]|\\(\\d{1,3}\\))[0-9\\-\\. ]{3,15}$"
        val PATTERN: Pattern = Pattern.compile(REG)
        fun CharSequence.isPhoneNumber() : Boolean = PATTERN.matcher(this).find()

        return "8089845216".isPhoneNumber()
    }
    private fun signUp(name: String, email: String,phoneNum: String, password: String){

        mAuth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    Log.d("ITM","success signup")
                    // code for jumping to home
                    val user = mAuth.currentUser
                    if (user != null) {
                        //addUserToDatabase(name, email, mAuth.currentUser?.uid!!)
                        val intent = Intent(this@SignUp, ActivityLogin::class.java)
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or
                                Intent.FLAG_ACTIVITY_NEW_TASK)
                        startActivity(intent)
                    }

                } else {
                    Log.d("ITM","fail signup")
                    Toast.makeText(this@SignUp, "Some error occurred", Toast.LENGTH_SHORT).show()
                }
            }
    }
/*
    private fun addUserToDatabase(name:String, email:String, uid:String){

        mDbRef = Firebase.database.reference
        mDbRef.child("user").child(uid).setValue(User(name, email, uid))

        val sharedPreference =  getSharedPreferences("User", Context.MODE_PRIVATE)
        val editor = sharedPreference.edit()
        editor.putString("UserId",uid)
        editor.apply()

        val intent = Intent(this@SignUp,MainActivity::class.java)
        //intent.putExtra("UserId", userid)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or
                Intent.FLAG_ACTIVITY_NEW_TASK)
        startActivity(intent)
        finish()

    }*/
}