package com.example.myyoutube

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import org.jsoup.Jsoup


class credits_activity : AppCompatActivity() {
    lateinit var topic : TextView
    lateinit var ds1 : Button
    lateinit var ds2 : Button
    lateinit var ds3 : Button
    lateinit var ds4 : Button
    lateinit var ds5 : Button
    lateinit var topic2 : TextView
    lateinit var ds6 : Button
    lateinit var ds7 : Button
    lateinit var topic3 : TextView
    lateinit var ds8 : Button
    lateinit var ds9 : Button
    lateinit var ds10 : Button
    lateinit var ds11 : Button
    lateinit var ds12 : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_credits_activity)


        topic = findViewById(R.id.topic)
        ds1 = findViewById(R.id.ds1)
        ds2 = findViewById(R.id.ds2)
        ds3 = findViewById(R.id.ds3)
        ds4 = findViewById(R.id.ds4)
        ds5 = findViewById(R.id.ds5)
        topic2 = findViewById(R.id.topic2)
        ds6 = findViewById(R.id.ds6)
        ds7 = findViewById(R.id.ds7)
        topic3 = findViewById(R.id.topic3)
        ds8 = findViewById(R.id.ds8)
        ds9 = findViewById(R.id.ds9)
        ds10 = findViewById(R.id.ds10)
        ds11 = findViewById(R.id.ds11)
        ds12 = findViewById(R.id.ds12)

        ds1.setOnClickListener(){
            val intent= Intent(this@credits_activity, ds1_activity::class.java)
            startActivity(intent)

        }
        ds2.setOnClickListener(){
            val intent= Intent(this@credits_activity, ds2_activity::class.java)
            startActivity(intent)

        }

    }



}