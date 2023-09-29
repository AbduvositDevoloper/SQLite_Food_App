package com.uz.sqlitefoodapp.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.uz.sqlitefoodapp.adapter.RvAdapter
import com.uz.sqlitefoodapp.databinding.FragmentTaomlarBinding
import com.uz.sqlitefoodapp.db.MyDbHelper
import com.uz.sqlitefoodapp.model.User


class TaomlarFragment : Fragment() {

    private lateinit var binding: FragmentTaomlarBinding
    private lateinit var rvHelper: MyDbHelper
    private lateinit var rvAdapter: RvAdapter
    private lateinit var list: ArrayList<User>


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTaomlarBinding.inflate(layoutInflater, container, false)
        rvHelper = MyDbHelper(requireContext())

        list = ArrayList()
        list.addAll(rvHelper.getAllTaom())
        rvAdapter = RvAdapter(list)
        binding.myrv.adapter = rvAdapter

        rvAdapter.onClick = {
            Toast.makeText(requireContext(), "click", Toast.LENGTH_SHORT).show()
        }
        return binding.root
    }
}