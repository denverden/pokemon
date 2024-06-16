package com.example.pokemon

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.pokemon.databinding.ActivityInfoBinding
import com.example.pokemon.model.Pokemon

class InfoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityInfoBinding

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val items = listOf(
            Pokemon(4, "Charmander", 6, 85, listOf("Fire"), R.drawable.charmander, "#FD7D24"),
            Pokemon(25, "Pikachu", 4, 60, listOf("Electric"), R.drawable.pikachu, "#E0B330"),
            Pokemon(9, "Blastoise", 16, 855, listOf("Water"), R.drawable.blastoise, "#4592C4"),
        )

        val position = intent.getIntExtra("position", -1)

        if (position != -1) {
            binding.pokemonImage.setImageResource(items[position].image)
            binding.info.setBackgroundColor(Color.parseColor(items[position].color))
            binding.infoAbout.setTextColor(Color.parseColor(items[position].color))
            binding.infoType.text = items[position].type.joinToString(separator = ", ")
            binding.pokemonName.text = items[position].name
            binding.infoHeight.text = items[position].height.toString()
            binding.infoWeight.text = items[position].weight.toString()
        } else {
            binding.pokemonImage.setImageResource(R.drawable.logo)
            binding.infoType.text = "@string/app_not_found"
            binding.pokemonName.text = "@string/app_not_found"
            binding.infoHeight.text = "@string/app_not_found"
            binding.infoWeight.text = "@string/app_not_found"
        }

        binding.btnBack.setOnClickListener {
            finish()
        }
    }
}