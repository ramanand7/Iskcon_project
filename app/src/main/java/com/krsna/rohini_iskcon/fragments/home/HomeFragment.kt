package com.krsna.rohini_iskcon.fragments.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import com.krsna.rohini_iskcon.MainActivity
import com.krsna.rohini_iskcon.R
import com.krsna.rohini_iskcon.fragments.home.aartis.AartiActivity
import com.krsna.rohini_iskcon.fragments.home.pranamMantras.PranamMantras
import com.krsna.rohini_iskcon.fragments.home.prayers.PrayersMain
import com.krsna.rohini_iskcon.fragments.home.shlokas.ShlokasMain

class HomeFragment : Fragment() {
    
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_home, container, false)
        com.krsna.rohini_iskcon.MainActivity.screen = "home"
        val btnAarti: ConstraintLayout = view.findViewById(R.id.btn_aarti)
        btnAarti.setOnClickListener {
            val i = Intent(context, AartiActivity::class.java)
            startActivity(i)
        }
        
        val buttonPranamMantras : ConstraintLayout = view.findViewById(R.id.btn_pranam_mantra)
        buttonPranamMantras.setOnClickListener{
            val i = Intent(context, PranamMantras::class.java)
            startActivity(i)
        }
        
        val btnPrayers: ConstraintLayout = view.findViewById(R.id.btn_prayer)
        btnPrayers.setOnClickListener{
            val i = Intent(context, PrayersMain::class.java)
            startActivity(i)
        }
        
        val btnShlokas: ConstraintLayout = view.findViewById(R.id.btn_shlokas)
        btnShlokas.setOnClickListener{
            val i = Intent(context, ShlokasMain::class.java)
            startActivity(i)
        }
        
        return view
    }
    
}