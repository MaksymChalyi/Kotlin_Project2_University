package com.example.lab2kotlinuniversity

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.lab2kotlinuniversity.databinding.FragmentSecondBinding

class SecondFragment : Fragment() {
    private var _binding : FragmentSecondBinding? = null
    private val binding get() = _binding!!

    companion object{
        const val numberInArray = "number"
        const val name = "name"
        const val desc = "desc"
        const val url = "url"
        const val fullDesc = "fullDesc"
    }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) { // method for work with button etc.
        super.onViewCreated(view, savedInstanceState)
        binding.tvName.text = arguments?.getString(name)
        binding.tvDescription.text = arguments?.getString(desc)
        binding.tvSecondFullDesc.text = arguments?.getString(fullDesc)
        Glide.with(view).load(arguments?.getString(url)).fitCenter().into(binding.tvPhoto)

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}