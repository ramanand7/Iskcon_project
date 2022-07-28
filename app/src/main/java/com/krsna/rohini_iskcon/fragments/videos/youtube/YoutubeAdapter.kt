package com.krsna.rohini_iskcon.fragments.videos.youtube

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.krsna.rohini_iskcon.R
import com.krsna.rohini_iskcon.fragments.videos.youtube.YoutubeAdapter.MyViewHolder
import com.squareup.picasso.Picasso
import java.util.*

class YoutubeAdapter(var context: Context?, var list: ArrayList<YoutubeModel>) : RecyclerView.Adapter<MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.video_item, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val model = list[position]
        holder.textView.text = model.title
        Picasso.get().load(model.url).into(holder.imageView)
        holder.imageView.setOnClickListener {
            val i = Intent(context, YoutubePlayActivity::class.java)
            i.putExtra("videoid", model.videoId)
            i.putExtra("description",model.description)
            context?.startActivity(i)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imageView: ImageView = itemView.findViewById(R.id.iv_thumbnail)
        var textView: TextView = itemView.findViewById(R.id.title_video)
        var playButton: ImageView = itemView.findViewById(R.id.iv_play_button)
    }
}