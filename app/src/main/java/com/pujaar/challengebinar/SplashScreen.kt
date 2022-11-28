package com.pujaar.challengebinar

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import com.pujaar.challengebinar.databinding.ActivitySplashScreenBinding
import kotlinx.android.synthetic.main.activity_splash_screen.*

class SplashScreen : AppCompatActivity() {
    lateinit var binding: ActivitySplashScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        binding = ActivitySplashScreenBinding.inflate(layoutInflater) // membuat binding layout

        setAnim() // memanggil fungsi anim
        supportActionBar?.hide()
        //set splash screen untuk 3 detik
        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }, 3000)
    }
    //fungsi membuat anim
    fun setAnim() {
        binding.tvOne.visibility = View.VISIBLE
        binding.tvTwo.visibility = View.VISIBLE
        binding.tvThree.visibility = View.VISIBLE
        val animFadeIn = AnimationUtils.loadAnimation(this, R.anim.fade_in)
        binding.tvOne.startAnimation(animFadeIn)
        binding.tvTwo.startAnimation(animFadeIn)
        binding.tvThree.startAnimation(animFadeIn)
    }
}