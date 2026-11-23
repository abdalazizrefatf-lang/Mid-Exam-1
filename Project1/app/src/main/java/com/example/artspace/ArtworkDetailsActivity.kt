package com.example.artspace;

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ArtworkDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_artwork_details)

        val title = intent.getStringExtra("TITLE")
        val artist = intent.getStringExtra("ARTIST")
        val year = intent.getStringExtra("YEAR")

        findViewById<TextView>(R.id.tvDetails).text =
                "Title: $title\nArtist: $artist\nYear: $year"

        findViewById<Button>(R.id.btnBack).setOnClickListener { finish() }
    }
}