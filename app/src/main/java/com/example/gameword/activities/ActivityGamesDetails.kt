package com.example.gameword.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.gameword.base.BaseActivity
import com.example.gameword.databinding.ActivityGamesDetailsBinding
/**
 * TO GET DETAILS PASSED THROUGH INTENT AS SERIALIZABLE OBJECT
 * Example: intent.getSerializableExtra(<KEY>) as <REQUIRED OBJECT>
 * Note: DON'T FORGET TO CHECK IF THE EXTRA OBJECT IS NULL OR HAVE NULL VALUE WHICH ARE PASSED
 */
class ActivityGamesDetails : BaseActivity() {
    private lateinit var binding: ActivityGamesDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGamesDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}