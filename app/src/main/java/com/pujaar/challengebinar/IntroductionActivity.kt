package com.pujaar.challengebinar

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.pujaar.challengebinar.adapter.IntroAdapter
import com.pujaar.challengebinar.databinding.ActivityIntroductionBinding
import kotlinx.android.synthetic.main.activity_introduction.*

class IntroductionActivity : AppCompatActivity() {
    lateinit var binding: ActivityIntroductionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityIntroductionBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        setFragment()
        setViewPager()

    }
    // mengset adapter serta worm indicatot
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
