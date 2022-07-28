package com.krsna.rohini_iskcon

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.krsna.rohini_iskcon.fragments.*
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.messaging.FirebaseMessaging
import com.krsna.rohini_iskcon.fragments.audio.AudioFragment
import com.krsna.rohini_iskcon.fragments.books.BooksFragment
import com.krsna.rohini_iskcon.fragments.contact.ContactusFragment
import com.krsna.rohini_iskcon.fragments.home.HomeFragment
import com.krsna.rohini_iskcon.fragments.notification.NotificationFragment
import com.krsna.rohini_iskcon.fragments.videos.VideoFragment
import de.hdodenhof.circleimageview.CircleImageView


class MainActivity : AppCompatActivity() {

    private var backPressedTime:Long = 0
    private var bottomNavigationView: BottomNavigationView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        window.statusBarColor = Color.BLACK

        FirebaseMessaging.getInstance().subscribeToTopic("all")

        bottomNavigationView = findViewById(R.id.main_navigation_bar)
        val homeFragment = HomeFragment()
        val notificationFragment = NotificationFragment()
        val accountFragment = BooksFragment()
        val audioFragment = AudioFragment()
        val videoFragment = VideoFragment()

        setFragment(homeFragment)

        val contactClick = findViewById<ImageView>(R.id.contact_us)
        contactClick.setOnClickListener {
            val fragmentBodyBottomSheet = ContactusFragment()
            fragmentBodyBottomSheet.show(supportFragmentManager, "contact")
        }

        val krsnaPic = findViewById<CircleImageView>(R.id.krsna_image)
        krsnaPic.setOnClickListener {
            val intent = Intent(this@MainActivity, com.krsna.rohini_iskcon.DeityImageActivity::class.java)
            startActivity(intent)
        }

        bottomNavigationView?.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.nav_home -> {
                    setFragment(homeFragment)
                    true
                }
                R.id.nav_notification -> {
                    setFragment(notificationFragment)
                    true
                }
                R.id.nav_books -> {
                    setFragment(accountFragment)
                    true
                }
                R.id.nav_audio -> {
                    setFragment(audioFragment)
                    true
                }
                R.id.nav_video -> {
                    setFragment(videoFragment)
                    true
                }
                else -> true
            }
        }

    }

    private fun setFragment(fragment: Fragment) {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.main_frame, fragment)
        fragmentTransaction.commit()
    }

    override fun onBackPressed() {
        when (com.krsna.rohini_iskcon.MainActivity.Companion.screen) {
            "kirtan", "sl", "sphl", "spel" -> setFragment(AudioFragment())
            "audio", "books", "notification", "video"  ->{
                setFragment(HomeFragment())
                bottomNavigationView?.selectedItemId = R.id.nav_home

            }
            "home"-> {
                if (backPressedTime + 2000 > System.currentTimeMillis()) {
                    super.onBackPressed()
                    return
                } else {
                    Toast.makeText(this, "Press back again to leave the app.", Toast.LENGTH_SHORT)
                        .show()
                }
                backPressedTime = System.currentTimeMillis()
            }
        }
    }

    companion object{
        var screen = "home"
    }

}
