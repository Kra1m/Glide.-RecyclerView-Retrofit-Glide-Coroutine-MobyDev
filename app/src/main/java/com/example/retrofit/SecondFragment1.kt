package com.example.navigationcomponent

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.retrofit.R
import com.example.retrofit.data.RetrofitService
import com.example.retrofit.databinding.FragmentSecond1Binding
import kotlinx.coroutines.launch

class SecondFragment1 : Fragment() {
    private lateinit var binding: FragmentSecond1Binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSecond1Binding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnFragment.setOnClickListener {
            findNavController().navigate(R.id.action_secondFragment12_to_firstFragment)
        }

        binding.btnRandomTdyFact.setOnClickListener {
            viewLifecycleOwner.lifecycleScope.launch {
                try {
                    val data = RetrofitService.apiServiceToday.getTodayFacts()
                    binding.textForSecondFragment.text = data.text
                }catch (e: Exception){
                    Log.d("meow", e.message.toString())
                }
            }
        }
    }

}