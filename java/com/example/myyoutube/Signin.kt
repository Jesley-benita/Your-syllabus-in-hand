package com.example.myyoutube

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast


class Signin : AppCompatActivity() {
    lateinit var regtitle: TextView
    lateinit var regname: EditText
    lateinit var regmail: EditText
    lateinit var regpass: EditText
    lateinit var regnum: EditText
    lateinit var regconfpass: EditText
    lateinit var regloginbtn: Button
    lateinit var regregister: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.sign_in)

        regtitle = findViewById(R.id.regtitle)
        regname = findViewById(R.id.regname)
        regmail = findViewById(R.id.regmail)
        regpass = findViewById(R.id.regpass)
        regnum = findViewById(R.id.regnum)
        regconfpass = findViewById(R.id.regconfpass)
        regloginbtn = findViewById(R.id.regloginbtn)
        regregister = findViewById(R.id.regregister)

        regregister.setOnClickListener() {
            if (!validation()||!validation1()||!validation2()||!validation3()||!validation4()) {
                onLoginFailed()
            } else {
                val intent = Intent(this@Signin, MainActivity::class.java)
                startActivity(intent)
                finish()

            }
        }
        regloginbtn.setOnClickListener() {
            val intent = Intent(this@Signin, MainActivity2::class.java)
            startActivity(intent)
        }

    }

    fun validation(): Boolean {
        var valid: Boolean
        var name = regname.text.toString()





        if (name.isEmpty()) {
            regname.error = "Enter your name"
            valid = false
        } else {
            valid = true

              }
        return valid
    }
    fun validation1(): Boolean {
        var valid: Boolean
        var mail = regmail.text.toString()
        if (mail.isEmpty()||!android.util.Patterns.EMAIL_ADDRESS.matcher(mail).matches()) {
            regmail.error = "Enter your email id"
            valid = false
        } else {
            valid = true
        }
        return valid
    }

    fun validation2(): Boolean {
        var valid: Boolean
        var pass = regpass.text.toString()
        if (pass.isEmpty() || pass.length < 4) {
            regpass.error = "Enter your password"
            valid = false
        } else {
            valid = true
        }
        return valid
    }


    fun validation3(): Boolean {
        var valid: Boolean
        var pass = regpass.text.toString()
        var confpass = regconfpass.text.toString()
        if (confpass.isEmpty() || confpass!= pass ) {
            regconfpass.error = "enter your password which you have already given"
            valid = false
        } else {
            valid = true

        }
        return valid
    }

    fun validation4(): Boolean {
        var valid: Boolean
        var num = regnum.text.toString()
        if ( num.isEmpty()) {
            regnum.error = "enter your phone number"
            valid = false
        } else {
            valid = true

        }
        return valid
    }














    fun onLoginFailed() {
        Toast.makeText(
            this@Signin,
            "login process failed",
            Toast.LENGTH_LONG
        ).show()
    }
}
