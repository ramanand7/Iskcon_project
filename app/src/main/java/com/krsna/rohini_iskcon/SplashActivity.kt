package com.krsna.rohini_iskcon

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val quotes = arrayListOf(
            "Religion without philosophy is sentiment, or sometimes fanaticism, while philosophy without religion is mental speculation",
            "Our only business is to love God, not to ask God for our necessities.",
            "Religion means to know God and to love Him",
            "First-class religion teaches one how to love God without any motive. If I serve God for some profit, that is business-not love",
            "He lives forever by his divine instructions, and the follower lives with him",
            "Books are the basis; purity is the force; preaching is the essence; utility is the principle",
            "Advancement in Krsna consciousness depends on the attitude of the follower",
            "You should not be carried away by the dictation of the mind, but the mind should be carried by your dictation.",
            "Devotional service is more or less a declaration of war against the illusory energy.",
            "To become free from sinful life, there is only simple method: if you surrender to Krsna. That is the beginning of bhakti."
        )
        val index = (0 until quotes.size).shuffled().first()
        val quoteTextView = findViewById<TextView>(R.id.tv_quote)
        quoteTextView.text = quotes[index]

        Handler(Looper.getMainLooper()).postDelayed({
            val mySuperIntent = Intent(this@SplashActivity, com.krsna.rohini_iskcon.MainActivity::class.java)
            startActivity(mySuperIntent)
            finish()
        }, 40*(quotes[index].length.toLong()))
    }
}