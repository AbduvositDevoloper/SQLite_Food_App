package com.uz.sqlitefoodapp.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.uz.sqlitefoodapp.R
import com.uz.sqlitefoodapp.databinding.FragmentBoshBinding


class BoshFragment : Fragment() {

    private lateinit var binding: FragmentBoshBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBoshBinding.inflate(layoutInflater, container, false)

        binding.newTaom.setOnClickListener {
            findNavController().navigate(
                R.id.taomQoshishFragment,
            )
        }

        binding.royTaom.setOnClickListener {
            findNavController().navigate(
                R.id.taomlarFragment,
            )
        }

        return binding.root
    }
}