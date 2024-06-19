package com.example.pokemon

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.pokemon.model.Pokemon

class Adapter(private val items: List<Pokemon>, private val context: Context) : RecyclerView.Adapter<Adapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val cardView: CardView = view.findViewById(R.id.list_card)
        val textView: TextView = view.findViewById(R.id.list_name)
        val imageView: ImageView = view.findViewById(R.id.list_image)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.custom_card_view, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textView.text = items[position].name
        holder.textView.setTextColor(Color.parseColor(items[position].color))
        holder.imageView.setImageResource(items[position].image)

        holder.cardView.setOnClickListener {
            val intent = Intent(context, InfoActivity::class.java)
            intent.putExtra("position", position)
            context.startActivity(intent)
        }
    }

    override fun getItemCount() = items.size
}