package com.krsna.rohini_iskcon.fragments.notification

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.krsna.rohini_iskcon.MainActivity
import com.krsna.rohini_iskcon.R
import com.google.firebase.database.*

class NotificationFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_notification, container, false)
        MainActivity.screen = "notification"
        val recyclerView: RecyclerView = view.findViewById(R.id.rv_notification)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(context)
        val progressCircle: ProgressBar = view.findViewById(R.id.progress_circle)
        val uploads: MutableList<NotificationModel> = ArrayList()
        val databaseRef: DatabaseReference = FirebaseDatabase.getInstance().getReference("messages")
        databaseRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                for (postSnapshot in dataSnapshot.children) {
                    val upload = postSnapshot.getValue(NotificationModel::class.java)
                    if (upload != null) {
                        uploads.add(upload)
                    }
                }
                val adapter = NotificationAdapter(context, uploads as ArrayList<NotificationModel?>)
                recyclerView.adapter = adapter
                progressCircle.visibility = View.INVISIBLE
            }

            override fun onCancelled(databaseError: DatabaseError) {
                Toast.makeText(context, databaseError.message, Toast.LENGTH_SHORT).show()
                progressCircle.visibility = View.INVISIBLE
            }
        })
        return view
    }
}