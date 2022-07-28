package com.krsna.rohini_iskcon

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class DeityImageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_deity_image)
        window.statusBarColor = Color.BLACK
    }

}