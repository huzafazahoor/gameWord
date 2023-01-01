package com.example.gameword


import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gameword.adapters.RecyclerViewAdapter


class homePage : AppCompatActivity() {

    private var layoutManager : RecyclerView.LayoutManager? = null
    private var adapter : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_page)

        val recyclerview = findViewById<RecyclerView>(R.id.recyclerView)

        layoutManager = LinearLayoutManager(this)
        adapter = RecyclerViewAdapter()
        recyclerview.layoutManager = layoutManager
        recyclerview.adapter = adapter


    }


}