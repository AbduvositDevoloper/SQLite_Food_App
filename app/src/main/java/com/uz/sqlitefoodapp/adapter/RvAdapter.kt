package com.uz.sqlitefoodapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.uz.sqlitefoodapp.databinding.ItemTaomBinding
import com.uz.sqlitefoodapp.model.User

class RvAdapter(
    private val list: ArrayList<User>

) : RecyclerView.Adapter<RvAdapter.Vh>() {

    lateinit var onClick: () -> Unit

    inner class Vh(private val rvitem: ItemTaomBinding) : RecyclerView.ViewHolder(rvitem.root) {
        fun onBind(user: User) {
            rvitem.name.text = user.name
            rvitem.button.setOnClickListener { onClick() }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(ItemTaomBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.onBind(list[position])
    }
}