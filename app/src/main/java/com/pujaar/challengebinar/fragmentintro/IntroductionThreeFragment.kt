package com.pujaar.challengebinar.fragmentintro


import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar
import com.pujaar.challengebinar.GameSelection
import com.pujaar.challengebinar.databinding.FragmentIntroductionThreeBinding



class IntroductionThreeFragment : Fragment() {
lateinit var binding : FragmentIntroductionThreeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentIntroductionThreeBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setOnClick()

    }

    companion object {
        fun newInstance(page:Int)= IntroductionThreeFragment()
    }

    private fun setOnClick(){
        binding.apply {
            etUrname.doOnTextChanged { text, start, before, count ->
                if ((text?.length?: 0)>0){
                    ivNextpage.visibility = View.VISIBLE
                }else{
                    ivNextpage.visibility = View.GONE
                }
            }
            ivNextpage.setOnClickListener(){
                val nameplayer= etUrname.text.toString()
                val intent = Intent(requireContext(), GameSelection::class.java)
                intent.putExtra("name",etUrname.text.toString())
                startActivity(intent)
            }
        }
    }

}