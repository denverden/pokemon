package com.example.pokemon.customRecycleView

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pokemon.InfoActivity
import com.example.pokemon.R
import com.example.pokemon.databinding.CustomCardViewBinding
import com.example.pokemon.model.Pokemon

class customAdapter(private val items: List<Pokemon>, private val context: Context) : RecyclerView.Adapter<customAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private var binding = CustomCardViewBinding.bind(view)
        val cardView = binding.listCard
        val textView = binding.listName
        val imageView = binding.listImage
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.custom_card_view, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        with(holder) {
            textView.text = items[position].name
            textView.setTextColor(Color.parseColor(items[position].color))
            imageView.setImageResource(items[position].image)

            cardView.setOnClickListener {
                val intent = Intent(context, InfoActivity::class.java)
                intent.putExtra("position", position)
                context.startActivity(intent)
            }
        }
    }

    override fun getItemCount() = items.size
}