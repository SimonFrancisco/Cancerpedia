package com.example.cancerpedia.cancerscreens

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.cancerpedia.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Calling SlashScreen - Everything is in res-themes and AndroidManifest
        //Duration of SplashScreen
        Thread.sleep(1000)
        installSplashScreen()
        setContentView(R.layout.activity_main)
    }
}