package com.example.myyoutube

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.FrameLayout
import android.widget.Toast

import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_signin.*


class MainActivity : AppCompatActivity() {
    lateinit var drawerlayout :DrawerLayout
    lateinit var coordinator:CoordinatorLayout
    lateinit var toolbar: Toolbar
    lateinit var frame:FrameLayout
    lateinit var navigation:NavigationView
    lateinit var butds:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContentView(R.layout.activity_signin)
        title="Clean india"

        drawerlayout=findViewById(R.id.drawerlayout)
        coordinator=findViewById(R.id.coordinator)
        toolbar=findViewById(R.id.toolbar)
        frame=findViewById(R.id. frame)
        navigation=findViewById(R.id.navigation)
        butds=findViewById(R.id.butds)


        setuptoolbar()
        var actionBarDrawerToggle =ActionBarDrawerToggle(

            this@MainActivity,
            drawerlayout,
            R.string.open_drawer,
            R.string.close_drawer
        )
        butds .setOnClickListener(){
            val intent = Intent(
                this@MainActivity,
                credits_activity::class.java
            )
            startActivity(intent)
            finish()
        }
        drawerlayout.addDrawerListener(actionBarDrawerToggle)
        actionBarDrawerToggle.syncState()

        navigation.setNavigationItemSelectedListener {


            when(it.itemId){
                R.id.menuprofile->{
                    val intent =Intent(this@MainActivity, profile_activity::class.java)
                    startActivity(intent)
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frame, profileFragment())
                        .commit()
                    drawerlayout.closeDrawers()
                }
                R.id.menucredits->{
                    val intent =Intent(this@MainActivity, credits_activity::class.java)
                    startActivity(intent)
                    drawerlayout.closeDrawers()
                }
                R.id.settings->{
                    val intent =Intent(this@MainActivity, settings_activity::class.java)
                    startActivity(intent)
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frame, settingsFragment())
                        .commit()
                    drawerlayout.closeDrawers()
                }
                R.id.aboutme->{
                    val intent =Intent(this@MainActivity, about_activity::class.java)
                    startActivity(intent)
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frame, aboutFragment())
                        .commit()
                    drawerlayout.closeDrawers()

                }
                R.id.signout->{
                    Toast.makeText(
                        this@MainActivity,
                        "Sign out done",
                        Toast.LENGTH_LONG
                    ).show()

                }
            }
            return@setNavigationItemSelectedListener true
        }

    }


    fun setuptoolbar(){
        setSupportActionBar(toolbar)
        supportActionBar?.title="Clean India"
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        val id = item.itemId
        if (id == android.R.id.home){
            drawerlayout.openDrawer(GravityCompat.START)
        }

        return super.onOptionsItemSelected(item)
    }


}