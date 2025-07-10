package com.example.emptyviewsactivity

import android.content.Context
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val listView = findViewById<ListView>(R.id.listView)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.listView))
        { view, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            view.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val fruits = listOf("apple","banana","cherry","date")
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, fruits)

        listView.adapter = adapter
        listView.setOnItemClickListener{ parent, view, position, id ->
            // handle click
            var positionSelected = position.toString()
            var text = "hi there $positionSelected"

            Toast.makeText(this ,text, 9).show()

        }
    }
}
