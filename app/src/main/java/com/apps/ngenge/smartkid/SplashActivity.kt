package com.apps.ngenge.smartkid

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        val actionBar = supportActionBar
        if(actionBar != null)
        {
            actionBar.hide()
        }

        Handler()
                .postDelayed({

                    startActivity(Intent(this@SplashActivity,MainActivity::class.java))
                    finish()

                },1200)
    }
}
