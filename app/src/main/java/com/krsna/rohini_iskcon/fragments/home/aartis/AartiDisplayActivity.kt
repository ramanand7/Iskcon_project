package com.krsna.rohini_iskcon.fragments.home.aartis

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.krsna.rohini_iskcon.R

class AartiDisplayActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_aarti_display)

        val aartiTitle = findViewById<TextView>(R.id.aarti_title)
        val aartiTv = findViewById<TextView>(R.id.aarti_text)
        val translationTv = findViewById<TextView>(R.id.aarti_translation)
        aartiTv.text = intent.extras?.getString("aarti")
        translationTv.text = intent.extras?.getString("translation")
        aartiTitle.text = intent.extras?.getString("title")

    }

}