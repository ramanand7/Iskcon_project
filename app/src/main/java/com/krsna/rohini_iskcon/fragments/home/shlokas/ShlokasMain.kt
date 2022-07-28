package com.krsna.rohini_iskcon.fragments.home.shlokas

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.krsna.rohini_iskcon.R

class ShlokasMain : AppCompatActivity() {
    var b1: Button? = null
    var b2: Button? = null
    var b3: Button? = null
    var b4: Button? = null
    var b5: Button? = null
    var b6: Button? = null
    var b7: Button? = null
    var b8: Button? = null
    var b9: Button? = null
    var b10: Button? = null
    var b11: Button? = null
    var b12: Button? = null
    var b13: Button? = null
    var b14: Button? = null
    var b15: Button? = null
    var b16: Button? = null
    var b17: Button? = null
    var b18: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shlokas_main)
        b1 = findViewById(R.id.ch_1_bt)
        b2 = findViewById(R.id.ch_2_bt)
        b3 = findViewById(R.id.ch_3_bt)
        b4 = findViewById(R.id.ch_4_bt)
        b5 = findViewById(R.id.ch_5_bt)
        b6 = findViewById(R.id.ch_6_bt)
        b7 = findViewById(R.id.ch_7_bt)
        b8 = findViewById(R.id.ch_8_bt)
        b9 = findViewById(R.id.ch_9_bt)
        b10 = findViewById(R.id.ch_10_bt)
        b11 = findViewById(R.id.ch_11_bt)
        b12 = findViewById(R.id.ch_12_bt)
        b13 = findViewById(R.id.ch_13_bt)
        b14 = findViewById(R.id.ch_14_bt)
        b15 = findViewById(R.id.ch_15_bt)
        b18 = findViewById(R.id.ch_18_bt)
        b1?.setOnClickListener(View.OnClickListener {
            val i = Intent(this@ShlokasMain, CH1::class.java)
            startActivity(i)
        })
        b2?.setOnClickListener(View.OnClickListener {
            val i = Intent(this@ShlokasMain, CH2::class.java)
            startActivity(i)
        })
        b3?.setOnClickListener(View.OnClickListener {
            val i = Intent(this@ShlokasMain, CH3::class.java)
            startActivity(i)
        })
        b4?.setOnClickListener(View.OnClickListener {
            val i = Intent(this@ShlokasMain, CH4::class.java)
            startActivity(i)
        })
        b5?.setOnClickListener(View.OnClickListener {
            val i = Intent(this@ShlokasMain, CH5::class.java)
            startActivity(i)
        })
        b6?.setOnClickListener(View.OnClickListener {
            val i = Intent(this@ShlokasMain, CH6::class.java)
            startActivity(i)
        })
        b7?.setOnClickListener(View.OnClickListener {
            val i = Intent(this@ShlokasMain, CH7::class.java)
            startActivity(i)
        })
        b8?.setOnClickListener(View.OnClickListener {
            val i = Intent(this@ShlokasMain, CH8::class.java)
            startActivity(i)
        })
        b9?.setOnClickListener(View.OnClickListener {
            val i = Intent(this@ShlokasMain, CH9::class.java)
            startActivity(i)
        })
        b10?.setOnClickListener(View.OnClickListener {
            val i = Intent(this@ShlokasMain, CH10::class.java)
            startActivity(i)
        })
        b11?.setOnClickListener(View.OnClickListener {
            val i = Intent(this@ShlokasMain, CH11::class.java)
            startActivity(i)
        })
        b12?.setOnClickListener(View.OnClickListener {
            val i = Intent(this@ShlokasMain, CH12::class.java)
            startActivity(i)
        })
        b13?.setOnClickListener(View.OnClickListener {
            val i = Intent(this@ShlokasMain, CH13::class.java)
            startActivity(i)
        })
        b14?.setOnClickListener(View.OnClickListener {
            val i = Intent(this@ShlokasMain, CH14::class.java)
            startActivity(i)
        })
        b15?.setOnClickListener(View.OnClickListener {
            val i = Intent(this@ShlokasMain, CH15::class.java)
            startActivity(i)
        })
        b18?.setOnClickListener(View.OnClickListener {
            val i = Intent(this@ShlokasMain, CH18::class.java)
            startActivity(i)
        })
    }
}