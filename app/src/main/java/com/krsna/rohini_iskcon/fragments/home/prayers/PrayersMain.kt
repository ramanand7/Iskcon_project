package com.krsna.rohini_iskcon.fragments.home.prayers

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.krsna.rohini_iskcon.R

class PrayersMain : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_prayers_main)
        val bhogaPrayer: Button = findViewById(R.id.bhogoffering)
        val manglaCarana: Button= findViewById(R.id.mangalkarna)
        val prasadamPrayer : Button= findViewById(R.id.prasadprayer)
        val pushpanjali: Button = findViewById(R.id.pushpanjali)

        bhogaPrayer.setOnClickListener{
            startActivity(
                Intent(
                    applicationContext, BhogaOffering::class.java
                )
            )
        }
        manglaCarana.setOnClickListener{
            startActivity(
                Intent(
                    applicationContext,
                    MangalaCarana::class.java
                )
            )
        }
        prasadamPrayer.setOnClickListener{
            startActivity(
                Intent(
                    applicationContext,
                    PrasadPrayer::class.java
                )
            )
        }
        pushpanjali.setOnClickListener{
            startActivity(
                Intent(
                    applicationContext,
                    Pushpanjali::class.java
                )
            )
        }
    }
}