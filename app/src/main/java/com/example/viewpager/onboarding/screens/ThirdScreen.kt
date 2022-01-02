package com.example.viewpager.onboarding.screens

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentTabHost
import androidx.navigation.fragment.findNavController
import com.example.viewpager.R
import com.example.viewpager.databinding.FragmentThirdScreenBinding

class ThirdScreen : Fragment() {

    private var _binding: FragmentThirdScreenBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentThirdScreenBinding.inflate(layoutInflater)
        val view = binding.root

        binding.finish.setOnClickListener {
            findNavController().navigate(R.id.action_viewPagerFragment_to_homeFragment)
            onBoardingFinished()
        }

        return view
    }

    private fun onBoardingFinished(){
        val sharedPref = activity?.getSharedPreferences("onBoarding",Context.MODE_PRIVATE) ?: return
        with (sharedPref.edit()) {
            putBoolean("Finished", true)
            apply()
        }
    }

}
