package com.krsna.rohini_iskcon.fragments.contact

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import com.krsna.rohini_iskcon.R
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class ContactusFragment : BottomSheetDialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v = inflater.inflate(R.layout.fragment_contactus_bottomsheet, container, false)
        val call: Button = v.findViewById(R.id.call_button)
        val cross: ImageView = v.findViewById(R.id.cross_image)

        cross.setOnClickListener {
            dismiss()
        }
        call.setOnClickListener {
            val phone = "+9136120402"
            val intent = Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phone, null))
            startActivity(intent)
        }
        return v
    }

    override fun getTheme(): Int {
        return R.style.AppBottomSheetDialogTheme
    }
}