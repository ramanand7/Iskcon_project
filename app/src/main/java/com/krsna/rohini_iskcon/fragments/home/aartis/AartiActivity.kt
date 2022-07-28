package com.krsna.rohini_iskcon.fragments.home.aartis

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.krsna.rohini_iskcon.R

class AartiActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_aarti_main)

        val btnMangla: Button = findViewById(R.id.btn_mangla)
        val btnNarsingh: Button = findViewById(R.id.btn_narsingh)
        val btnTulasi: Button = findViewById(R.id.btn_tulasi)
        val btnShiskshastkam: Button = findViewById(R.id.btn_shishastaskam)
        val btnTenOffences: Button = findViewById(R.id.btn_tenoffences)
        val btnGaura: Button = findViewById(R.id.btn_gaura)

        btnMangla.setOnClickListener{
            val intent = Intent(applicationContext, AartiDisplayActivity::class.java)
            intent.putExtra("title", getString(R.string.mangla_aarti))
            intent.putExtra("aarti", getString(R.string.mangla_aart_text))
            intent.putExtra("translation", getString(R.string.mangla_aarti_translation))
            startActivity(intent)
        }
        btnNarsingh.setOnClickListener{
            val intent = Intent(applicationContext, AartiDisplayActivity::class.java)
            intent.putExtra("title", getString(R.string.narsingh_aarti))
            intent.putExtra("aarti", getString(R.string.narsingh_aarti_text))
            intent.putExtra("translation", getString(R.string.narsingh_aarti_translation))
            startActivity(intent)
        }
        btnTulasi.setOnClickListener{
            val intent = Intent(applicationContext, AartiDisplayActivity::class.java)
            intent.putExtra("title", getString(R.string.tulasi_aarti))
            intent.putExtra("aarti", getString(R.string.tulasi_aarti_text))
            intent.putExtra("translation", getString(R.string.tulasi_aarti_translation))
            startActivity(intent)
        }
        btnShiskshastkam.setOnClickListener{
            val intent = Intent(applicationContext, AartiDisplayActivity::class.java)
            intent.putExtra("title", getString(R.string.shikshastamkam))
            intent.putExtra("aarti", getString(R.string.shikshastkam_aarti_text))
            intent.putExtra("translation", getString(R.string.shikshastakam_aarti_translation))
            startActivity(intent)
        }
        btnTenOffences.setOnClickListener{
            val intent = Intent(applicationContext, AartiDisplayActivity::class.java)
            intent.putExtra("title", getString(R.string.ten_offences_to_the_holy_name))
            intent.putExtra("aarti", getString(R.string.ten_offences_text))
            intent.putExtra("translation", getString(R.string.tens_offenxces_translation))
            startActivity(intent)
        }
        btnGaura.setOnClickListener {
            val intent = Intent(applicationContext, AartiDisplayActivity::class.java)
            intent.putExtra("title", getString(R.string.gaura_aarti))
            intent.putExtra("aarti", getString(R.string.gaur_aarti_text))
            intent.putExtra("translation", getString(R.string.gaur_aarti_translation))
            startActivity(intent)
        }
    }
}