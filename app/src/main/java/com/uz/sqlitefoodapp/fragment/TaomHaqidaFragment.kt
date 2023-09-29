package com.uz.sqlitefoodapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.uz.sqlitefoodapp.R
import com.uz.sqlitefoodapp.databinding.FragmentBoshBinding
import com.uz.sqlitefoodapp.databinding.FragmentTaomHaqidaBinding


class TaomHaqidaFragment : Fragment() {

    private lateinit var binding: FragmentTaomHaqidaBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTaomHaqidaBinding.inflate(layoutInflater, container, false)
        return binding.root
    }


}