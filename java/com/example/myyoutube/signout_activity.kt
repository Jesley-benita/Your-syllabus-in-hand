package com.example.myyoutube

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class signout_activity : AppCompatActivity() {
    lateinit var signout: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

         signout=findViewById(R.id.signout)
        signout .setOnClickListener(){
                val intent = Intent(
                    this@signout_activity,
                    MainActivity2::class.java
                )
            startActivity(intent)
            finish()
            }
        }
    }
