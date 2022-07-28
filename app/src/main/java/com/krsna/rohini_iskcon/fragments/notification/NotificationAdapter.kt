package com.krsna.rohini_iskcon.fragments.notification

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.krsna.rohini_iskcon.R
import java.util.*


class NotificationAdapter(private val mContext: Context?, private val mUploads: List<NotificationModel?>) :
    RecyclerView.Adapter<NotificationAdapter.MessageViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageViewHolder {
        val view = LayoutInflater.from(mContext).inflate(R.layout.notification_item, parent, false)
        return MessageViewHolder(view)
    }

    override fun onBindViewHolder(holder: MessageViewHolder, position: Int) {
        val uploadCurrent = mUploads[position]
        holder.textViewName.text = uploadCurrent!!.getmName()
        holder.mu.text = uploadCurrent.date.toString()
    }

    override fun getItemCount(): Int {
        return mUploads.size
    }

    class MessageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var textViewName: TextView = itemView.findViewById(R.id.tv_message)
        var mu: TextView = itemView.findViewById(R.id.tv_date)
    }

    init {
        Collections.reverse(mUploads)
    }
}