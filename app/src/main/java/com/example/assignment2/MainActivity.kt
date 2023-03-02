package com.example.assignment2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.widget.Toolbar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val primaryToolbar = findViewById<Toolbar>(R.id.primary_toolbar)
        setSupportActionBar(primaryToolbar)
    }

   override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.toolbar_menu,menu)
        return super.onCreateOptionsMenu(menu)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.task1 ->{
                val intent = Intent(this, Grid1::class.java)
                startActivity(intent)
            }
            R.id.task2 ->{
                val intent = Intent(this, Grid2::class.java)
                startActivity(intent)

            }
            R.id.task3 ->{
                val intent = Intent(this, Calculator::class.java)
                startActivity(intent)

            }
            R.id.task4 ->{

                val intent = Intent(this, MovieList::class.java)
                startActivity(intent)

            }
        }
        return super.onOptionsItemSelected(item)
    }

}