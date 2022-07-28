package com.krsna.rohini_iskcon.fragments.books

import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import com.krsna.rohini_iskcon.R
import java.net.URLEncoder

class PdfViewActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pdf_view)
        openWebView()
    }

    private fun openWebView(){
        val pdfview = findViewById<WebView>(R.id.pdfView)
        val fileUrl = intent.extras?.getString("fileurl")
        val url = URLEncoder.encode(fileUrl, "UTF-8")

        pdfview.webViewClient = WebViewClient()
        pdfview.settings.builtInZoomControls = true
        pdfview.settings.javaScriptEnabled = true

        pdfview.loadUrl("https://docs.google.com/viewer?url=$url")
    }

}
