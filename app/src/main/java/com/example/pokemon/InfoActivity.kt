package com.example.pokemon

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.pokemon.databinding.ActivityInfoBinding

class InfoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityInfoBinding

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val position = intent.getIntExtra("position", -1)
        val pokemon = PokemonMockData.getPokemonPosition(position)

        if (position != -1 && pokemon != null) {
            binding.pokemonImage.setImageResource(pokemon.image)
            binding.info.setBackgroundColor(Color.parseColor(pokemon.color))
            binding.infoAbout.setTextColor(Color.parseColor(pokemon.color))
            binding.infoType.text = pokemon.type.joinToString(separator = ", ")
            binding.pokemonName.text = pokemon.name
            binding.infoHeight.text = pokemon.height.toString()
            binding.infoWeight.text = pokemon.weight.toString()
        } else {
            binding.pokemonImage.setImageResource(R.drawable.logo)
            binding.infoType.text = "not_found"
            binding.pokemonName.text = "not_found"
            binding.infoHeight.text = "not_found"
            binding.infoWeight.text = "not_found"
        }

        binding.btnBack.setOnClickListener {
            finish()
        }
    }
}