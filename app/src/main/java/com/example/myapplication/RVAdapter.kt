package com.example.myapplication

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.myapplication.databinding.ItemRecyclerBinding

class RVAdapter(val list: ArrayList<Data>) : Adapter<RVAdapter.ResponseHolder>() {

    class ResponseHolder(val binding: ItemRecyclerBinding) : ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ResponseHolder {
        return ResponseHolder(
            ItemRecyclerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ResponseHolder, position: Int) {
        val item = list[position]
        val binding = holder.binding
        binding.textID.text = item.id
        binding.textName.text = item.name
        binding.textDate.text = item.getFormattedTime("HH:mm dd.MM.yyyy")

        Glide.with(holder.itemView.context)
            .load(item.avatar)
            .into(binding.imageAvatar)

    }

}