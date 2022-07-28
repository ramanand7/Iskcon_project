package com.krsna.rohini_iskcon.fragments.books

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.krsna.rohini_iskcon.R
import com.krsna.rohini_iskcon.fragments.books.BookAdapter.BookViewHolder
import com.firebase.ui.database.FirebaseRecyclerAdapter
import com.firebase.ui.database.FirebaseRecyclerOptions
import com.squareup.picasso.Picasso
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity


class BookAdapter(val context: Context?, options: FirebaseRecyclerOptions<BookModel?>) :
    FirebaseRecyclerAdapter<BookModel, BookViewHolder>(options){

    override fun onBindViewHolder(holder: BookViewHolder, position: Int, bookModel: BookModel) {
        holder.header.text = bookModel.filename
        Picasso.get()
            .load(bookModel.imageuri)
            .into(holder.imgshow)

//        val image_picture = holder.imgshow
//        val drawable = image_picture.drawable ?: return
//        val viewWidth: Float = image_picture.width.toFloat()
//        val viewHeight: Float = image_picture.height.toFloat()
//        val drawableWidth = drawable.intrinsicWidth
//        val drawableHeight = drawable.intrinsicHeight
//
//        val widthScale = viewWidth / drawableWidth
//        val heightScale = viewHeight / drawableHeight
//        val scale = widthScale.coerceAtLeast(heightScale)
//
//        val matrix = Matrix()
//        matrix.reset()
//        matrix.postScale(scale, scale)
//        holder.imgshow.imageMatrix = matrix

        holder.img1.setOnClickListener {
            startActivity( holder.img1.context, Intent(Intent.ACTION_VIEW, Uri.parse(bookModel.fileurl)), null)
        }
        holder.imgshow.setOnClickListener {
            val intent = Intent(holder.imgshow.context, PdfViewActivity::class.java)
            intent.putExtra("filename", bookModel.filename)
            intent.putExtra("fileurl", bookModel.fileurl)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            holder.imgshow.context.startActivity(intent)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.book_item, parent, false)
        return BookViewHolder(view)
    }

    inner class BookViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var img1: ImageView = itemView.findViewById(R.id.iv_download_pdf)
        var imgshow: ImageView = itemView.findViewById(R.id.iv_book_cover_page)
        var header: TextView = itemView.findViewById(R.id.header)
    }

}