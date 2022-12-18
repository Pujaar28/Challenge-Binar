package com.pujaar.challengebinar.fragmentintro

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.pujaar.challengebinar.databinding.FragmentIntroductionOneBinding

class IntroductionOneFragment : Fragment() {
    lateinit var binding : FragmentIntroductionOneBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentIntroductionOneBinding.inflate(inflater,container,false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
    companion object{
        fun newInstance(page: Int)= IntroductionOneFragment()
    }

}