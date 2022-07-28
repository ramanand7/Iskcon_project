package com.krsna.rohini_iskcon.fragments.books

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.krsna.rohini_iskcon.MainActivity
import com.krsna.rohini_iskcon.R
import com.firebase.ui.database.FirebaseRecyclerOptions
import com.google.firebase.database.FirebaseDatabase

class BooksFragment : Fragment() {
    var rvBook: RecyclerView? = null
    var bookAdapter: BookAdapter? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_books, container, false)
        com.krsna.rohini_iskcon.MainActivity.screen = "books"
        rvBook = view.findViewById(R.id.rv_books)
        rvBook!!.layoutManager = GridLayoutManager(context, 2)

        val options = FirebaseRecyclerOptions.Builder<BookModel>()
            .setQuery(
                FirebaseDatabase.getInstance().reference.child("mydocuments"),
                BookModel::class.java
            )
            .build()
        bookAdapter = BookAdapter(context, options)
        rvBook!!.adapter = bookAdapter
        bookAdapter!!.startListening()

        return view
    }

    override fun onDestroy() {
        super.onDestroy()
        bookAdapter!!.stopListening()

    }

}