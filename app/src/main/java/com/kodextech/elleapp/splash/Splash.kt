package com.kodextech.elleapp.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.kodextech.elleapp.R
import com.kodextech.elleapp.auth.AuthAc

class Splash : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        setContentView(R.layout.activity_splash)
        super.onCreate(savedInstanceState)

        Handler(Looper.getMainLooper()).postDelayed({

            startActivity(Intent(this@Splash, AuthAc::class.java))
        },2000L)
    }
}