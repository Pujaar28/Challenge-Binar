package com.pujaar.challengebinar

import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.pujaar.challengebinar.adapter.IntroAdapter
import com.pujaar.challengebinar.databinding.ActivityIntroductionBinding

class IntroductionActivity : AppCompatActivity() {
    lateinit var binding: ActivityIntroductionBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityIntroductionBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        setFragment()
        setViewPager()
    }
    private fun setViewPager() {
        binding.apply {
            vpSlider.apply {
                adapter = IntroAdapter(this@IntroductionActivity)
                currentItem = 0
                wormIndicator.setViewPager2(vpSlider)
                }
            }
        }
    }
//    private fun setFragment(){
//        val fragment = IntroductionOneFragment()
//        supportFragmentManager.beginTransaction().apply {
//            replace(R.id.fr_layoutone,fragment)
//        }.commit()
//
//        val fragmenttwo=IntroductionTwoFragment()
//        supportFragmentManager.beginTransaction().apply {
//            replace(R.id.fr_layouttwo,fragmenttwo)
//        }.commit()
//    }