package com.example.gameword.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.gameword.base.BaseActivity
import com.example.gameword.databinding.ActivityGamesDetailsBinding

class ActivityGamesDetails : BaseActivity() {
    private var binding: ActivityGamesDetailsBinding ?= null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGamesDetailsBinding.inflate(layoutInflater)
        setContentView(binding!!.root)
    }
}