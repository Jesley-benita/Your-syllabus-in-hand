
package com.example.myyoutube

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.MenuItem
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import kotlinx.android.synthetic.main.activity_signin.*


class MainActivity2 : AppCompatActivity(){

    lateinit var topic: TextView
    lateinit var email: EditText
    lateinit var pass: EditText
    lateinit var login: Button
    lateinit var forgot: Button
    lateinit var reg: Button
    lateinit var sharedPreferences: SharedPreferences


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        sharedPreferences=getSharedPreferences(getString(R.string.preference_file_name), Context.MODE_PRIVATE)
        val loggedin= sharedPreferences.getBoolean("loggedin",false)
        if(loggedin){
            val intent= Intent(this@MainActivity2,MainActivity::class.java)
            startActivity(intent)
            finish()
        }
        else{setContentView(R.layout.login_page)}




        topic = findViewById(R.id.topic)!!
        email = findViewById(R.id.email)
        pass = findViewById(R.id.pass)
        login = findViewById(R.id.login)
        forgot = findViewById(R.id.forgot)
        reg = findViewById(R.id.reg)
        login.setOnClickListener() {


            if(!validation()||!validation1()){
                onLoginFailed()
            }else{

                savepreferences()
                val intent= Intent(this@MainActivity2,credits_activity::class.java)
                startActivity(intent)
                finish()

            }

        }




        reg.setOnClickListener(){
            val intent= Intent(this@MainActivity2, Signin::class.java)
            startActivity(intent)

        }
        forgot.setOnClickListener(){
            val intent =Intent(this@MainActivity2, forgetpassActivity::class.java)
            startActivity(intent)
        }


        }
     fun validation(): Boolean {
         var valid: Boolean

         var eemail = email.text.toString()

         if (eemail.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(eemail).matches()) {
             email.error = "enter a valid email address"
             valid = false
         } else {
             valid = true
         }
         return valid
     }

         fun validation1(): Boolean{
         var valid: Boolean

         var ppassword=pass.text.toString()
         if (ppassword.isEmpty()||ppassword.length<4){
            pass.error="between 4 and 10 alphanumeric characters"
            valid =false
        }else{
            valid=true
        }
        return valid
    }
        fun onLoginFailed(){
            Toast.makeText(
                this@MainActivity2,
                "login process failed",
                Toast.LENGTH_LONG
            ).show()


        }
     fun onLoginSuccess() {
         login.isEnabled = true

        finish()
         startActivity(Intent(this, MainActivity::class.java))
     }


    fun savepreferences(){
        sharedPreferences.edit().putBoolean("loggedin",true).apply()
    }



}






