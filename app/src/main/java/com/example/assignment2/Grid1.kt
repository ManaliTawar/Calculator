package com.example.assignment2;

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar

class Grid1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_grid1)
        val primaryToolbar = findViewById<Toolbar>(R.id.primary_toolbar)
        setSupportActionBar(primaryToolbar)
        supportActionBar?.title = "Grid 1 Layout"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }


}