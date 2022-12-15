package com.pujaar.challengebinar.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.pujaar.challengebinar.fragmentintro.IntroductionOneFragment
import com.pujaar.challengebinar.fragmentintro.IntroductionThreeFragment
import com.pujaar.challengebinar.fragmentintro.IntroductionTwoFragment

class IntroAdapter(fragmentActivity: FragmentActivity):
    FragmentStateAdapter(fragmentActivity){
    private val fragments = listOf(
        IntroductionOneFragment.newInstance(FIRST),
        IntroductionTwoFragment.newInstance(SECOND),
        IntroductionThreeFragment.newInstance(THIRD),
    )

    companion object{
        const val FIRST = 0
        const val SECOND = 1
        const val THIRD = 2
    }

    override fun getItemCount(): Int {
     return fragments.size
    }

    override fun createFragment(position: Int): Fragment = fragments[position]

}