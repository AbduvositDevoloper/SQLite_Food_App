package com.uz.sqlitefoodapp.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.uz.sqlitefoodapp.adapter.RvAdapter
import com.uz.sqlitefoodapp.databinding.FragmentTaomQoshishBinding
import com.uz.sqlitefoodapp.db.MyDbHelper
import com.uz.sqlitefoodapp.model.User


class TaomQoshishFragment : Fragment() {

    private lateinit var binding: FragmentTaomQoshishBinding
    private lateinit var rvHelper: MyDbHelper
    private lateinit var rvAdapter: RvAdapter
    private lateinit var list: ArrayList<User>


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTaomQoshishBinding.inflate(layoutInflater, container, false)
            rvHelper = MyDbHelper(requireContext())
            list = ArrayList()
            list.addAll(rvHelper.getAllTaom())
            rvAdapter = RvAdapter(list)



        binding.saveTaom.setOnClickListener {
            val user = User(
                name = binding.nameTam.text.toString(),
                mahsulotlar = binding.kerakliMa.text.toString(),
                tayTartibi = binding.tayyorTar.text.toString()
            )
            rvHelper.addUser(user)
            list.add(user)
            rvAdapter.notifyDataSetChanged()
            Toast.makeText(requireContext(), "Saqlandi", Toast.LENGTH_SHORT).show()

            binding.nameTam.setText("")
            binding.kerakliMa.setText("")
            binding.tayyorTar.setText("")

        }


        return binding.root
    }
}
