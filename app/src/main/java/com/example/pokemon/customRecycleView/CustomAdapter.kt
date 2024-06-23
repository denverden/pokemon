package com.example.pokemon.customRecycleView

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pokemon.databinding.CustomCardViewBinding
import com.example.pokemon.model.Pokemon

class CustomAdapter(private val items: List<Pokemon>, private val itemOnClick: (Int) -> Unit) : RecyclerView.Adapter<CustomViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val binding = CustomCardViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CustomViewHolder(binding, itemOnClick)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount() = items.size
}