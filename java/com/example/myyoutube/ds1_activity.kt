package com.example.myyoutube

import android.net.Uri
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.MediaController
import android.widget.TextView
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity


class ds1_activity : AppCompatActivity() {
    lateinit var topic : TextView
    lateinit var description : TextView
    lateinit var vedio:VideoView
    private val webView1: WebView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ds1)

       // topic = findViewById(R.id.topic)
       // description=findViewById(R.id.description)
       //// vedio=findViewById(R.id.vedio)
        val webView1 = findViewById<WebView>(R.id.webView1)

        webView1.webViewClient = WebViewClient()
        webView1.loadUrl("https://simplesnippets.tech/what-is-data-structures-what-is-an-algorithm-why-do-we-need-data-structures-algorithms/")
        val webSettings = webView1.settings
        webSettings.javaScriptEnabled = true

       // val mediaController =MediaController(this);
       // mediaController.setAnchorView(vedio)
       // val onlineUri= Uri.parse("https://www.videvo.net/video/business-businessman-hands-type-on-laptop-computer-close-up-/560926/")
       // val offlineUri=Uri.parse("android.resource://$packageName/${R.raw.plant}")
       // vedio.setMediaController(mediaController)
       // vedio.setVideoURI(onlineUri)
       // vedio.requestFocus()
       // vedio.start()
       // webView.getSettings().setJavaScriptEnabled(true);
        //webView.loadUrl("https://android-coffee.com");

        //val queue =Volley.newRequestQueue(activity as Context)
        //val url="https://jsonblob.com/2d8a7f4e-affd-11eb-83dc-9765cdde8b7f"
        ///val jsonObjectRequest=object:JsonObjectRequest(Request.Method.GET,url,null,response.Listener){

        ///}, Response.ErrorListener{

        ///}

    }override fun onBackPressed() {
        if (webView1!!.canGoBack()) {
            webView1.goBack()
        } else {
            super.onBackPressed()
        }
    }
}



