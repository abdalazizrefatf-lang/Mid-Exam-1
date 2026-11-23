package com.example.artspace;

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private val artworks = listOf(
            Artwork(R.drawable.art1, "Deep Field Stellar Deaths", "Smacs Carin", "2021", "https://esawebb.org"),
            Artwork(R.drawable.art2, "Cosmic Cliffs", "Artist Two", "2022", "https://esawebb.org"),
            Artwork(R.drawable.art3, "Pillars of Creation", "Artist Three", "2022", "https://esawebb.org"),
            Artwork(R.drawable.art4, "Southern Ring", "Artist Four", "2022", "https://esawebb.org"),
            Artwork(R.drawable.art5, "Stephan's Quintet", "Artist Five", "2022", "https://esawebb.org"),
            Artwork(R.drawable.art6, "Hubble Ngc Flat Final", "Sonay Billan", "2019", "https://esahubble.org")
    )
    private var index = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        index = savedInstanceState?.getInt("INDEX", 0) ?: 0

        findViewById<Button>(R.id.btnNext).setOnClickListener {
            if (index < artworks.size - 1) { index++; updateUI() }
        }
        findViewById<Button>(R.id.btnPrev).setOnClickListener {
            if (index > 0) { index--; updateUI() }
        }

        findViewById<ImageView>(R.id.ivArt).setOnClickListener {
            val a = artworks[index]
            val intent = Intent(this, ArtworkDetailsActivity::class.java).apply {
                putExtra("TITLE", a.title)
                putExtra("ARTIST", a.artist)
                putExtra("YEAR", a.year)
            }
            startActivity(intent)
        }

        findViewById<Button>(R.id.btnWebsite).setOnClickListener {
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(artworks[index].url)))
        }

        updateUI()
    }

    private fun updateUI() {
        val a = artworks[index]
        findViewById<ImageView>(R.id.ivArt).setImageResource(a.imageRes)
        findViewById<TextView>(R.id.tvTitle).text = a.title
        findViewById<TextView>(R.id.tvArtist).text = "${a.artist}  (${a.year})"
        findViewById<TextView>(R.id.tvCounter).text = "${index + 1} / ${artworks.size}"
        findViewById<Button>(R.id.btnPrev).isEnabled = index > 0
        findViewById<Button>(R.id.btnNext).isEnabled = index < artworks.size - 1
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("INDEX", index)
    }
}