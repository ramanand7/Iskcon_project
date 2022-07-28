package com.krsna.rohini_iskcon.fragments.home.pranamMantras

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.krsna.rohini_iskcon.R

class PranamMantras : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pranam_mantras_main)
        val bb1: Button = findViewById(R.id.SrīGuruPraṇāma)
        val bb2: Button = findViewById(R.id.SrīRūpaPraṇāma)
        val bb3: Button = findViewById(R.id.ŚrīlaPrabhupādaPraṇati)
        val bb4: Button = findViewById(R.id.SrīlaBhaktisiddhāntaSarasvatīPraṇati)
        val bb5 : Button= findViewById(R.id.SrīlaGaurakiśoraPraṇati)
        val bb6 : Button= findViewById(R.id.SrīlaBhaktivinodaPraṇati)
        val bb7 : Button= findViewById(R.id.SrīVaiṣṇavaPraṇāma)
        val bb8: Button = findViewById(R.id.ŚrīGaurāṅgaPraṇāma)
        val bb9 : Button= findViewById(R.id.SrīPañcatattvaPraṇāma)
        val bb10 : Button= findViewById(R.id.SrīKṛṣṇaPraṇāma)
        val bb11 : Button= findViewById(R.id.SambandhādhidevaPraṇāma)
        val bb12: Button = findViewById(R.id.AbhidheyādhidevaPraṇāma)
        val bb13 : Button= findViewById(R.id.PrayojanādhidevaPraṇāma)
        val bb14 : Button= findViewById(R.id.SrīRādhāPraṇāma)
        val bb15: Button = findViewById(R.id.PañcatattvaMahāmantra)
        val bb16 : Button= findViewById(R.id.HareKṛṣṇaMahāmantra)
        val bb17 : Button= findViewById(R.id.NityanandaPrabhuPranamaMantra)
        val bb18 : Button= findViewById(R.id.LordBalaramaPranamaMantra)
        val bb19 : Button= findViewById(R.id.SriKrishnaPranamaMantra)
        val bb20 : Button= findViewById(R.id.LorJagannathaPranamaMantra)

        bb1.setOnClickListener{
            val intent = Intent(applicationContext, o1::class.java)
            startActivity(intent)

        }
        bb2.setOnClickListener{
            val i = Intent(applicationContext, o2::class.java)
            startActivity(i)
        }
        bb3.setOnClickListener{
            val i = Intent(applicationContext, o3::class.java)
            startActivity(i)
        }
        bb4.setOnClickListener{
            val i = Intent(applicationContext, o4::class.java)
            startActivity(i)
        }
        bb5.setOnClickListener{
            val i = Intent(applicationContext, o5::class.java)
            startActivity(i)
        }
        bb6.setOnClickListener{
            val i = Intent(applicationContext, o6::class.java)
            startActivity(i)
        }
        bb7.setOnClickListener{
            val i = Intent(applicationContext, o7::class.java)
            startActivity(i)
        }
        bb8.setOnClickListener{
            val i = Intent(applicationContext, o8::class.java)
            startActivity(i)
        }
        bb9.setOnClickListener{
            val i = Intent(applicationContext, o9::class.java)
            startActivity(i)
        }
        bb10.setOnClickListener{
            val i = Intent(applicationContext, o10::class.java)
            startActivity(i)
        }
        bb11.setOnClickListener{
            val i = Intent(applicationContext, o11::class.java)
            startActivity(i)
        }
        bb12.setOnClickListener{
            val i = Intent(applicationContext, o12::class.java)
            startActivity(i)
        }
        bb13.setOnClickListener{
            val i = Intent(applicationContext, o13::class.java)
            startActivity(i)
        }
        bb14.setOnClickListener{
            val i = Intent(applicationContext, o14::class.java)
            startActivity(i)
        }
        bb15.setOnClickListener{
            val i = Intent(applicationContext, o15::class.java)
            startActivity(i)
        }
        bb16.setOnClickListener{
            val i = Intent(applicationContext, o16::class.java)
            startActivity(i)
        }
        bb17.setOnClickListener{
            val i = Intent(applicationContext, o17::class.java)
            startActivity(i)
        }
        bb18.setOnClickListener{
            val i = Intent(applicationContext, o18::class.java)
            startActivity(i)
        }
        bb19.setOnClickListener{
            val i = Intent(applicationContext, o19::class.java)
            startActivity(i)
        }
        bb20.setOnClickListener{
            val i = Intent(applicationContext, o20::class.java)
            startActivity(i)
        }
    }
}