package com.example.pokemon.customDiffUtil

import androidx.recyclerview.widget.DiffUtil
import com.example.pokemon.model.Pokemon

class CustomDiffUtil(
    private val oldItems: List<Pokemon>,
    private val newItems: List<Pokemon>
): DiffUtil.Callback() {

    override fun getOldListSize(): Int {
        return oldItems.size
    }

    override fun getNewListSize(): Int {
        return newItems.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldItems[oldItemPosition].id == newItems[newItemPosition].id
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldItems[oldItemPosition] == newItems[newItemPosition]
    }
}