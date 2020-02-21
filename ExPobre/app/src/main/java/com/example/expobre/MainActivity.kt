package com.example.expobre

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var tvNumbers: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.tvNumbers = findViewById(R.id.tvNumbers)
        this.tvNumbers.text = Megasena.getInstance().joinToString(" ")

        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener {
            this.tvNumbers.text = Megasena.getInstance().joinToString(" ")
        }
    }
}
