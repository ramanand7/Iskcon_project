package com.krsna.rohini_iskcon.fragments.audio

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.krsna.rohini_iskcon.MainActivity
import com.krsna.rohini_iskcon.fragments.audio.audiotypes.KirtanFragment
import com.krsna.rohini_iskcon.fragments.audio.audiotypes.SpecialLectureFragment
import com.krsna.rohini_iskcon.fragments.audio.audiotypes.EnglishLectureFragment
import com.krsna.rohini_iskcon.fragments.audio.audiotypes.HindiLectureFragment
import com.krsna.rohini_iskcon.R

class AudioFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_audio, container, false)
        MainActivity.screen = "audio"
        val hindiLectures: Button = view.findViewById(R.id.hindiLectures)
        hindiLectures.setOnClickListener{ setFragment(HindiLectureFragment()) }
        val englishLectures: Button = view.findViewById(R.id.english_lectures)
        englishLectures.setOnClickListener{ setFragment(EnglishLectureFragment()) }
        val specialLectures: Button = view.findViewById(R.id.special_lectures)
        specialLectures.setOnClickListener{ setFragment(SpecialLectureFragment()) }
        val kirtans: Button = view.findViewById(R.id.kirtans)
        kirtans.setOnClickListener{ setFragment(KirtanFragment()) }
        return view
    }

    private fun setFragment(fragment: Fragment) {
        val fragmentTransaction = parentFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.main_frame, fragment)
        fragmentTransaction.commit()
    }
}