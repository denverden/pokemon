package com.example.pokemon.customRecycleView

import androidx.recyclerview.widget.RecyclerView
import com.example.pokemon.databinding.CustomCardViewBinding
import com.example.pokemon.model.Pokemon

class CustomViewHolder(private val binding: CustomCardViewBinding, private val itemOnClick: (Int) -> Unit) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: Pokemon) {
        with(binding) {
            listName.text = item.name
            listName.setTextColor(android.graphics.Color.parseColor(item.color))
            listImage.setImageResource(item.image)
            listCard.setOnClickListener { itemOnClick(item.id) }
        }
    }
}