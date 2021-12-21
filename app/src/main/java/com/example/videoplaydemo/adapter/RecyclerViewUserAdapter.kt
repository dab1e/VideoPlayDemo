package com.example.videoplaydemo.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.videoplaydemo.databinding.ItemUserBinding
import com.example.videoplaydemo.network.User

class RecyclerViewUserAdapter(private val list:List<User>): RecyclerView.Adapter<RecyclerViewUserAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: ItemUserBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int){
            val user = list.get(position)
            binding.userName.text = user.user
            binding.userAge.text = user.age.toString()
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerViewUserAdapter.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemUserBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerViewUserAdapter.ViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int = list.size
}