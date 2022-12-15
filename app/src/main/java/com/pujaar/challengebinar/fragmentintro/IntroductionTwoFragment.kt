package com.pujaar.challengebinar.fragmentintro

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.pujaar.challengebinar.R
import com.pujaar.challengebinar.databinding.FragmentIntroductionTwoBinding


class IntroductionTwoFragment : Fragment() {
  lateinit var binding : FragmentIntroductionTwoBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentIntroductionTwoBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
    companion object{
        fun newInstance(page: Int)= IntroductionTwoFragment()
    }
}