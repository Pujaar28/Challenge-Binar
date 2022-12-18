package com.pujaar.challengebinar

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.pujaar.challengebinar.databinding.ActivitySplashScreenBinding

class SplashScreen : AppCompatActivity() {
    lateinit var binding: ActivitySplashScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        binding = ActivitySplashScreenBinding.inflate(layoutInflater) // membuat binding layout
        supportActionBar?.hide()
        setAnim()
        setSplash()
    }
    fun setSplash() {
        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, IntroductionActivity::class.java)
            startActivity(intent)
            finish()
        }, 3000)
    }

    fun setAnim() {
        binding.apply {
            imgSplashone.visibility = View.VISIBLE
            imgSplashone.visibility = View.VISIBLE
            val animFadeIn = AnimationUtils.loadAnimation(this@SplashScreen, R.anim.fade_in)
            imgSplashone.startAnimation(animFadeIn)
            imgSplashtwo.startAnimation(animFadeIn)
        }
    }

}