package com.example.waterdleiveryapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.waterdleiveryapp.databinding.ActivitySplashscreenBinding

class splashscreen : AppCompatActivity() {
    lateinit var binding: ActivitySplashscreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivitySplashscreenBinding.inflate(layoutInflater)
        setContentView(binding.root)



        //Go to main screen after 5000 mili sec
        Handler().postDelayed({

            startActivity(Intent(this,LoginActivity::class.java ))
            finish()
        },5000)



    }
}