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
import com.example.retrofit.databinding.FragmentFirstBinding
import kotlinx.coroutines.launch

class FirstFragment : Fragment() {

    private lateinit var binding: FragmentFirstBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFirstBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnChangeFragment1.setOnClickListener {
            findNavController().navigate(R.id.action_firstFragment_to_secondFragment12)
        }

        binding.btnFragment.setOnClickListener {
            viewLifecycleOwner.lifecycleScope.launch{
                try {
                    val data = RetrofitService.apiService.getFacts()
                    binding.textFacts.text = data.text
                }
                catch (e:Exception){
                    Log.d("aaa", e.message.toString())
                }
            }
        }
    }

}