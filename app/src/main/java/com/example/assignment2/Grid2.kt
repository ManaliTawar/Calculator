package com.example.assignment2;

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import com.example.assignment2.R.*


class Grid2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_grid2)
        val primaryToolbar = findViewById<Toolbar>(R.id.primary_toolbar)
        setSupportActionBar(primaryToolbar)
        supportActionBar?.title = "Grid 2 Layout"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
}