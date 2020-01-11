package com.example.uass.activity

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.Window
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.example.uass.R

class SplesScrean: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //hiding title bar of this activity
        window.requestFeature(Window.FEATURE_NO_TITLE)
        //making this activity full screen
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.spalsh_screen)

        //4second splash time
        Handler().postDelayed({
            //start main activity
            startActivity(Intent(this@SplesScrean, ActivityLogin::class.java))
            //finish this activity
            finish()
        },4000)

    }
}