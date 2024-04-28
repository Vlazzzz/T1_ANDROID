package com.example.tema1_android

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.Button


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val closeButton = findViewById<Button>(R.id.button_close)
        closeButton.setOnClickListener {
            finish() // Această linie va închide activitatea când butonul este apăsat
        }
    }
}