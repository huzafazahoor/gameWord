package com.example.gameword.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.gameword.R
import com.example.gameword.databinding.ActivityTournamentDetailsBinding
/**
 * TO GET DETAILS PASSED THROUGH INTENT AS SERIALIZABLE OBJECT
 * Example: intent.getSerializableExtra(<KEY>) as <REQUIRED OBJECT>
 * Note: DON'T FORGET TO CHECK IF THE EXTRA OBJECT IS NULL OR HAVE NULL VALUE WHICH ARE PASSED
 */
class ActivityTournamentDetails : AppCompatActivity() {
    private lateinit var binding:ActivityTournamentDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTournamentDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}